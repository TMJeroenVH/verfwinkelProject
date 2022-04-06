package be.thomasmore.verfwinkel.controllers;

import be.thomasmore.verfwinkel.model.Verfpot;
import be.thomasmore.verfwinkel.repositories.VerfpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class VerfpotController {
    private Logger logger = LoggerFactory.getLogger(VerfpotController.class);
    @Autowired
    private VerfpotRepository verfpotRepository;

    @GetMapping({"/verfdetail", "/verfdetail/{id}"})
    public String verfDetail(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "verfdetail";
        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        if (optionalVerfpot.isPresent()) {
            model.addAttribute("verfpot", optionalVerfpot.get());
        }
        return "verfdetail";
    }

    @GetMapping({"/verfpotten", "/verfpotten/{something}"})
    public String verfpotten(Model model) {
        Iterable<Verfpot> alleVerfPotten = verfpotRepository.findAll();
        model.addAttribute("aantalPotten", verfpotRepository.count());
        model.addAttribute("verfpotten", alleVerfPotten);
        return "verfpotten";
    }

    @GetMapping("/verfpotten/filter")
    public String verfpottenMetFilter(Model model,
                                      @RequestParam(required = false) Double minimumPrijs,
                                      @RequestParam(required = false) Double maximumPrijs,
                                      @RequestParam(required = false) String keyword) {
        logger.info("verfpottenMetFilter -- keyword=" + keyword);
        logger.info("verfpottenMetFilter -- minprijs=" + minimumPrijs);
        logger.info("verfpottenMetFilter -- maxprijs=" + maximumPrijs);

        List<Verfpot> verfPotten = verfpotRepository.findByPrijsAndNaam(
                minimumPrijs, maximumPrijs, keyword);

        model.addAttribute("minPrijs", minimumPrijs);
        model.addAttribute("maxPrijs", maximumPrijs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("verfpotten", verfPotten);
        model.addAttribute("aantalPotten", ((Collection<?>) verfPotten).size());
        model.addAttribute("showFilter", true);
        return "verfpotten";
    }


}

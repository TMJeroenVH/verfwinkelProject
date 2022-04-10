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

import java.security.Principal;
import java.util.*;

@Controller
public class VerfpotController {
    private Logger logger = LoggerFactory.getLogger(VerfpotController.class);
    @Autowired
    private VerfpotRepository verfpotRepository;

    @GetMapping({"/verfdetail", "/verfdetail/{id}"})
    public String verfDetail(Model model, Principal principal, @PathVariable(required = false) Integer id) {
        if (id == null) return "verfdetail";
        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        Optional<Verfpot> optionalPrev = verfpotRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Verfpot> optionalNext = verfpotRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalVerfpot.isPresent()) {
            Verfpot v = optionalVerfpot.get();
            model.addAttribute("verfpot", v);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", verfpotRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", verfpotRepository.findFirstByOrderByIdAsc().get().getId());
        }

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("verfdetail - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "verfdetail";
    }

    @GetMapping({"/verfpotten", "/verfpotten/{something}"})
    public String verfpotten(Model model, Principal principal) {
        Iterable<Verfpot> alleVerfPotten = verfpotRepository.findAll();
        model.addAttribute("aantalPotten", verfpotRepository.count());
        model.addAttribute("verfpotten", alleVerfPotten);
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("verfpotten - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "verfpotten";
    }

    @GetMapping("/verfpotten/filter")
    public String verfpottenMetFilter(Model model, Principal principal,
                                      @RequestParam(required = false) Double minimumPrijs,
                                      @RequestParam(required = false) Double maximumPrijs,
                                      @RequestParam(required = false) String keyword,
                                      @RequestParam(required = false) String ondergrond) {
        logger.info("verfpottenMetFilter -- keyword=" + keyword);
        logger.info("verfpottenMetFilter -- minprijs=" + minimumPrijs);
        logger.info("verfpottenMetFilter -- maxprijs=" + maximumPrijs);
        logger.info("verfpottenMetFilter -- ondergrond=" + ondergrond);

        List<Verfpot> verfPotten = verfpotRepository.findByPrijsNaam(
                minimumPrijs, maximumPrijs, keyword, ondergrond);

        model.addAttribute("minPrijs", minimumPrijs);
        model.addAttribute("maxPrijs", maximumPrijs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("ondergrond", ondergrond);
        model.addAttribute("verfpotten", verfPotten);
        model.addAttribute("aantalPotten", ((Collection<?>) verfPotten).size());
        model.addAttribute("showFilter", true);

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("verfpotten - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "verfpotten";
    }


}

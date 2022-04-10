package be.thomasmore.verfwinkel.controllers;
import be.thomasmore.verfwinkel.model.Verfpot;
import be.thomasmore.verfwinkel.repositories.VerfpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private VerfpotRepository verfpotRepository;
    @GetMapping({"/admin"})
    public String admin(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("admin - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "admin/admin";
    }

    @GetMapping("/verfAanpassen/{id}")
    public String verfAanpassen(Model model, @PathVariable int id) {
        logger.info("verfAanpassen"+id);
        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        if (optionalVerfpot.isPresent()) {
            model.addAttribute("verfpot", optionalVerfpot.get());
        }
        return "admin/verfAanpassen";
    }

    @PostMapping("/verfAanpassen/{id}")
    public String verfEditPost(Model model, @PathVariable int id,
                               @ModelAttribute("verfpot") Verfpot verfpot) {
        logger.info("verdeditpost : " + id + " -- new name: " + verfpot.getNaam());
        logger.info("verdeditpost : " + id + " -- new og: " + verfpot.getOndergrond());
        logger.info("verdeditpost : " + id + " -- new kleur: " + verfpot.getKleurAanbod());
        logger.info("verdeditpost : " + id + " -- new vp: " + verfpot.getVerpakkingMogelijkheden());
        logger.info("verdeditpost : " + id + " -- new prijs: " + verfpot.getPrijs());

        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        if (optionalVerfpot.isPresent()) {
            Verfpot verfpotVoorUpdate = optionalVerfpot.get();
            verfpotVoorUpdate.setNaam(verfpot.getNaam());
            verfpotVoorUpdate.setOndergrond(verfpot.getOndergrond());
            verfpotVoorUpdate.setKleurAanbod(verfpot.getKleurAanbod());
            verfpotVoorUpdate.setVerpakkingMogelijkheden(verfpot.getVerpakkingMogelijkheden());
            verfpotVoorUpdate.setPrijs(verfpot.getPrijs());
            verfpotRepository.save(verfpot);
        }
        return "redirect:/verfdetail/"+id;
    }

    @GetMapping("/verfToevoegen")
    public String verfToevoegen(Model model) {
        logger.info("verfToevoegen");
        model.addAttribute("verpotten", verfpotRepository.findAll());
        return "admin/verfToevoegen";
    }

    @ModelAttribute("verfpot")
    public Verfpot findVerfpot(@PathVariable(required = false) Integer id) {
        logger.info("findVerfpot "+id);
        if (id!=null) {
            Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
            if (optionalVerfpot.isPresent()) return optionalVerfpot.get();
        }
        return new Verfpot();
    }

    @PostMapping("/verfToevoegen")
    public String verfToevoegenPost(Model model, @ModelAttribute("verfpot") Verfpot verfpot) {
        logger.info("verfToevoegenPost -- new name=" + verfpot.getNaam() + ", prijs=" + verfpot.getPrijs());
        verfpotRepository.save(verfpot);
        return "redirect:/verfdetail/"+verfpot.getId();
    }
}

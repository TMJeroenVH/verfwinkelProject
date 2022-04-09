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
import java.util.Optional;

@Controller
public class VerfdetailController {
    @Autowired
    private VerfpotRepository verfpotRepository;
    private Logger logger = LoggerFactory.getLogger(VerfdetailController.class);

    @GetMapping({"/verfdetail/bestelpagina/{id}"})
    public String bestelPagina(Model model, Principal principal,  @PathVariable(required = false) Integer id) {
        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        if (optionalVerfpot.isPresent()) {
            model.addAttribute("verfpot", optionalVerfpot.get());
        }
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("bestelling - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "bestelpagina";
    }

    @GetMapping({"/bevestigingspagina"})
    public String bestelVerf(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("bevestiging - logged in as " + loginName);
        model.addAttribute("principal", principal);


        return "bevestigingspagina";
    }
}

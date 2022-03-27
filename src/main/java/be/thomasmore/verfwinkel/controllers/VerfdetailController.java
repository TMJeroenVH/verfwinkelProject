package be.thomasmore.verfwinkel.controllers;

import be.thomasmore.verfwinkel.model.Verfpot;
import be.thomasmore.verfwinkel.repositories.VerfpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class VerfdetailController {
    @Autowired
    private VerfpotRepository verfpotRepository;

    @GetMapping({"/verfdetail/bestelpagina/{id}"})
    public String bestelVerf(Model model, @PathVariable(required = false) Integer id){
        Optional<Verfpot> optionalVerfpot = verfpotRepository.findById(id);
        if (optionalVerfpot.isPresent()){
            model.addAttribute("verfpot", optionalVerfpot.get());
        }

        return "bestelpagina";
    }
}

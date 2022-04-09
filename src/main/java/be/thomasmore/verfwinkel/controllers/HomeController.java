package be.thomasmore.verfwinkel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("about - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "about";
    }
}



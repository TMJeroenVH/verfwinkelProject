package be.thomasmore.verfwinkel.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @GetMapping({"/admin/admin"})
    public String admin(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("admin - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "admin/admin";
    }
}

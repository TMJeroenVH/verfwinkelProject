package be.thomasmore.verfwinkel.controllers;

import be.thomasmore.verfwinkel.model.Klant;
import be.thomasmore.verfwinkel.model.User;
import be.thomasmore.verfwinkel.repositories.KlantenRepository;
import be.thomasmore.verfwinkel.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KlantenRepository klantenRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/verfpotten";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {
        if (principal == null) return "redirect:/verfpotten";
        return "user/logout";
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/verfpotten";
        return "user/register";
    }

    @PostMapping("/register")
    public String registerPost(Principal principal,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String mail,
                               @RequestParam String city) {
        if (principal != null) return "redirect:/verfpotten";
        if (username==null || username.trim().equals("")) return "redirect:/verfpotten";
        if (password==null || password.trim().equals("")) return "redirect:/verfpotten";
        if (mail==null || mail.trim().equals("")) return "redirect:/verfpotten";
        username = username.trim();
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) return "redirect:/verfpotten";
        String encodedPassword = encoder.encode(password.trim());
        User user = new User(username, encodedPassword, "ROLE_USER");
        userRepository.save(user);
        Klant klant = new Klant(name.trim(), city.trim(), user, mail.trim());
        klantenRepository.save(klant);
        autologin(username, password.trim());
        return "redirect:/verfpotten";
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            logger.info("authentication: " + auth.isAuthenticated());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

}
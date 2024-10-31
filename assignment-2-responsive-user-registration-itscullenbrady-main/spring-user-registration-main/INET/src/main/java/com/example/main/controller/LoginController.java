package com.example.main.controller;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;
import com.example.main.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    final
    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String submitRegistration(@ModelAttribute User user, Model model) {
        UserValidation userValidation = new UserValidationImpl(userRepository);
        ValidationResult validationResult = userValidation.validateUser(user.getUsername(),
                user.getEmail(), user.getPassword());
        if(!validationResult.isInputValid()) {
            model.addAttribute("v", validationResult);
            return "register";
        } else {
            UserRegistration userRegistration = new UserRegistrationImpl(userRepository);
            userRegistration.registerUser(validationResult);
            model.addAttribute("v", validationResult);
            return "welcome";
        }
    }


    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("v", new ValidationResult(new User()));
        return "register";
    }

    @PostMapping("/login")
public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
    // Perform login validation
    UserValidation userValidation = new UserValidationImpl(userRepository);
    ValidationResult validationResult = userValidation.validateUser(username, "", password);

    // Check if the validation is successful
    if (validationResult.isInputValid()) {
        // Redirect to inside.html
        return "redirect:/inside";
    } else {
        // Add error message to the model
        model.addAttribute("error", "Invalid username or password.");
        return "login";
    }
}

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
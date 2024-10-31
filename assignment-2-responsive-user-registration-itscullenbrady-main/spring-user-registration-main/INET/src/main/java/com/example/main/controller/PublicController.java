package com.example.main.controller;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PublicController {

    final
    UserRepository userRepository;

    public PublicController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}

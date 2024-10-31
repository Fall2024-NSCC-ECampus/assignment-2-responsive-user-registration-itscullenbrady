package com.example.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InsideController {

    @GetMapping("/inside")
    public String inside() {
        return "inside";
    }

}

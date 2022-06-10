package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/deny")
    public String deny() {
        return "403";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

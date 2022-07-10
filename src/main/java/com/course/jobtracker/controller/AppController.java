package com.course.jobtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String welcome(ModelMap model) {
        model.addAttribute("page", "home");
        return "app";
    }

}

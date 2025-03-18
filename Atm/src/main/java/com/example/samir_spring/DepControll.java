package com.example.samir_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepControll {
    @GetMapping("/deposit")
    public String depo(Model model) {
        // Add any necessary model attributes
        return "deposit";
    }
}
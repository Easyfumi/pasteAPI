package ru.marinin.paste.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainController(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }
}

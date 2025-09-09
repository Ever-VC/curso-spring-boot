package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo desde Spring Boot como monolito! :)");
        model.addAttribute("name", "Ever");
        model.addAttribute("lastName", "Vasquez");
        com.ever.curso.springboot.webapp.springbootweb.models.User user = new User("Ever", "Vasquez");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/details2")
    public String details2(Map<String, Object> model) {
        model.put("title", "Hola Mundo desde Spring Boot como monolito! :)");
        model.put("name", "Ever");
        model.put("lastName", "Vasquez");
        return "details";
    }
}

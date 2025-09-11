package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo desde Spring Boot como monolito! :)");
        model.addAttribute("name", "Ever");
        model.addAttribute("lastName", "Vasquez");
        User user = new User("Ever", "Vasquez");
        //user.setEmail("ever@ever.com");
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

    @GetMapping("/list")
    public String list(ModelMap model) {
        //var users = usersModel();
        //model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Maria", "Francisca", "mari@gamil.com"),
                new User("Pedro", "Fernandez"),
                new User("Juan", "Perez", "juanjo123@gamil.com"),
                new User("Andres", "Guzman"),
                new User("John", "Doe", "john@gamil.com")
        );
    }
}

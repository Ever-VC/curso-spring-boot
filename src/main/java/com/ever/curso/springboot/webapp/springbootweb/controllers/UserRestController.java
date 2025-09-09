package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.User;
import com.ever.curso.springboot.webapp.springbootweb.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Ever", "Vasquez");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo desde Spring Boot como monolito! :)");
        body.put("name", "Ever");
        body.put("lastName", "Vasquez");
        body.put("user", user);
        return body;
    }

    // Usando DTO en vez de Map
    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        User user = new User("Ever", "Vasquez");
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo desde Spring Boot");
        userDto.setUser(user);
        return userDto;
    }
}

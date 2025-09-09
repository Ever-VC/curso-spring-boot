package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.User;
import com.ever.curso.springboot.webapp.springbootweb.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    // Obtener lista de usuarios (sería lo mismo para arreglos pero con List es más común, en caso de usar arreglo sería User[])
    @GetMapping("/users")
    public List<User> list() {
        User ever = new User("Ever", "Vasquez");
        User juan = new User("Juan", "Perez");
        User andres = new User("Andres", "Guzman");
        User john = new User("John", "Doe");
        // Crear una lista inmutable con List.of (Java 9+), funciona cuando ya tenemos los elementos
        List<User> users = List.of(ever, juan, andres, john);
        //List<User> users = Arrays.asList(ever, juan, andres, john); // Otra forma de crear una lista
        return users;
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

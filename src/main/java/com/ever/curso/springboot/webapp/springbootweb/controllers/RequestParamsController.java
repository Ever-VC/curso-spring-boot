package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false) String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message!=null?message:"Hola Mundo desde Spring Boot");
        return paramDto;
    }
}

package com.ever.curso.springboot.webapp.springbootweb.controllers;

import com.ever.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(name = "mensaje", required = false, defaultValue = "Hola Mundo como valor por defecto") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto paramsDto = new ParamDto();
        paramsDto.setMessage(text);
        paramsDto.setCode(code);
        return paramsDto;
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        Integer code = 10;
        ParamDto paramsDto = new ParamDto();
        paramsDto.setMessage(request.getParameter("text"));
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {

        }
        paramsDto.setCode(code);
        return paramsDto;
    }
}

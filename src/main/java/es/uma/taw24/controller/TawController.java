package es.uma.taw24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TawController {
    @GetMapping("/")
    public String doInicio() {
        return "inicio";
    }
}

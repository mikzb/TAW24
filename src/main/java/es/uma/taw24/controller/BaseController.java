package es.uma.taw24.controller;

import jakarta.servlet.http.HttpSession;

public class BaseController {

    protected boolean estaAutenticado(HttpSession session) {
        return session.getAttribute("usuario") != null;
    }

    protected String redirectToLogin() {
        return "redirect:/";
    }
}

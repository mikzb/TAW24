/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cliente")
public class ClienteController extends BaseController{

    private static int clienteID = 1;

    @GetMapping("/")
    public String doInicio(HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        return "inicioCliente";
    }

    @GetMapping("/entrenamientoCliente")
    public String doEntrenamientoCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        return "entrenamientoCliente";
    }

    @GetMapping("/dietaCliente")
    public String doDietaCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        return "dietaCliente";
    }

}

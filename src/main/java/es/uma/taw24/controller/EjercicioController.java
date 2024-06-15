package es.uma.taw24.controller;

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.service.EjercicioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController extends BaseController{

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/listado")
    public String listarComidas(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/listado";
        ArrayList<Ejercicio> ejercicios = (ArrayList<Ejercicio>) this.ejercicioService.listarEjercicios();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("ejercicios", ejercicios);
        return strTo;
    }
}

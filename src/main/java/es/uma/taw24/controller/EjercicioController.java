package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */


import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.service.EjercicioService;
import es.uma.taw24.service.TipoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController extends BaseController{

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private TipoService tipoService;

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

    @GetMapping("/editar")
    public String editarEjercicio(@RequestParam("id") int id, Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/editar";
        Ejercicio ejercicio = this.ejercicioService.buscarPorId(id);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("tipos", this.tipoService.listarTipos());
        model.addAttribute("ejercicio", ejercicio);
        return strTo;
    }

    @PostMapping("/editar")
    public String editarEjercicio(@ModelAttribute("comida") Ejercicio ejercicio, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {
            this.ejercicioService.guardarEjercicio(ejercicio);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "ejercicio/editar";
        }
        return strTo;
    }

    @GetMapping("/borrar")
    public String borrarEjercicio(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {
            this.ejercicioService.borrarEjercicio(id);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return strTo;
    }

    @GetMapping("/crear")
    public String crearEjercicio(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/crear";
        model.addAttribute("tipos", this.tipoService.listarTipos());
        model.addAttribute("ejercicio", new Ejercicio());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearEjercicio(@ModelAttribute("comida") Ejercicio ejercicio, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {
            this.ejercicioService.guardarEjercicio(ejercicio);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "ejercicio/crear";
        }
        return strTo;
    }
}

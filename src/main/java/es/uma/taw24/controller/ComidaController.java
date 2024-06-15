package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.service.ComidaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/comida")
public class ComidaController extends BaseController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping("/listado")
    public String listarComidas(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "comida/listado";
        ArrayList<Comida> comidas = (ArrayList<Comida>) this.comidaService.listarComidas();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("comidas", comidas);
        return strTo;
    }

    @GetMapping("/editar")
    public String editarComida(@RequestParam("id") int id, Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "comida/editar";
        Comida comida = this.comidaService.buscarPorId(id);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("comida", comida);
        return strTo;
    }

    @PostMapping("/editar")
    public String editarComida(@ModelAttribute("comida") Comida comida, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/comida/listado";
        try {
            this.comidaService.guardarComida(comida);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "comida/editar";
        }
        return strTo;
    }

    @GetMapping("/borrar")
    public String borrarComida(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/comida/listado";
        try {
            this.comidaService.borrarComida(id);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return strTo;
    }

    @GetMapping("/crear")
    public String crearComida(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "comida/crear";
        model.addAttribute("comida", new Comida());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearComida(@ModelAttribute("comida") Comida comida, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/comida/listado";
        try {
            this.comidaService.guardarComida(comida);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "comida/crear";
        }
        return strTo;
    }
}

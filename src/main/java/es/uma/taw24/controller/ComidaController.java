package es.uma.taw24.controller;

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.service.ComidaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

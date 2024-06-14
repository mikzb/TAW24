package es.uma.taw24.controller;


import es.uma.taw24.DTO.Tipo;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.service.TipoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/tipo")
public class TipoController extends BaseController{

    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listarTipos(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "tipo/listado";
        ArrayList<Tipo> tipos = (ArrayList<Tipo>) this.tipoService.listarTipos();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("tipos", tipos);
        return strTo;
    }
}

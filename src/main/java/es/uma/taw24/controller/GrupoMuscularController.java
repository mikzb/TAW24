package es.uma.taw24.controller;

import es.uma.taw24.DTO.GrupoMuscular;
import es.uma.taw24.DTO.Tipo;
import es.uma.taw24.service.GrupoMuscularService;
import es.uma.taw24.service.TipoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/grupomuscular")
public class GrupoMuscularController extends BaseController{
    @Autowired
    private GrupoMuscularService grupoMuscularService;

    @GetMapping("/listado")
    public String listarTipos(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "grupomuscular/listado";
        ArrayList<GrupoMuscular> gruposMusculares = (ArrayList<GrupoMuscular>) this.grupoMuscularService.listarGruposMusculares();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("gruposmusculares", gruposMusculares);
        return strTo;
    }
}

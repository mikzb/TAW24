package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Tipo;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.service.TipoService;
import es.uma.taw24.ui.FiltroTipo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/tipo")
public class TipoController extends BaseController{

    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listar(Model model, HttpSession session){
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
        model.addAttribute("filtro", new FiltroTipo());
        return strTo;
    }

    @GetMapping("/editar")
    public String editarTipo(@RequestParam("id") int id, Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "tipo/editar";
        Tipo tipo = this.tipoService.buscarPorId(id);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("tipo", tipo);
        return strTo;
    }

    @PostMapping("/editar")
    public String editarTipo(@ModelAttribute("tipo") Tipo tipo, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        this.tipoService.guardarTipo(tipo);
        return "redirect:/tipo/listado";
    }

    @GetMapping("/borrar")
    public String borrarTipo(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/tipo/listado";
        try {
            this.tipoService.borrarTipo(id);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return strTo;
    }

    @GetMapping("/crear")
    public String crearTipo(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "tipo/crear";
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("tipo", new Tipo());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearTipo(@ModelAttribute("tipo") Tipo tipo, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        this.tipoService.guardarTipo(tipo);
        return "redirect:/tipo/listado";
    }

    @PostMapping("/filtrar")
    public String filtrar(@ModelAttribute("filtro")FiltroTipo filtro, Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }

        String strTo = "tipo/listado";
        if (filtro.estaVacio()) {
            strTo = "redirect:/tipo/listado";
        } else {
            ArrayList<Tipo> tipos = (ArrayList<Tipo>) this.tipoService.listarTiposPorFiltro(filtro);
            model.addAttribute("usuario", session.getAttribute("usuario"));
            model.addAttribute("tipos", tipos);
        }
        return strTo;
    }
}

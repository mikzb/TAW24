package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.exception.UserNotFoundException;
import es.uma.taw24.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends BaseController{

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/")
    public String listadoUsuarios(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/listado";
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return strTo;
    }

    @GetMapping("/crear")
    public String crearUsuario(Model model, HttpSession session) {
        String strTo = "usuario/crear";
        model.addAttribute("usuario", new Usuario());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        String strTo = "redirect:/usuario/";
        if (this.usuarioService.emailOcupado(usuario.getEmail())) {
            model.addAttribute("error", "El email " + usuario.getEmail() + " esta ocupado.");
            strTo = "usuario/crear";
        } else {
            this.usuarioService.guardarUsuario(usuario);
        }
        return strTo;
    }

    @GetMapping("/editar")
    public String editarUsuario(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/editar";
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            model.addAttribute("usuario", usuario);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/listado";
        }
        return strTo;
    }
    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/usuario/";
        try {
            this.usuarioService.guardarUsuario(usuario);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/editar";
        }
        return strTo;
    }



}

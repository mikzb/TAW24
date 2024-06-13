package es.uma.taw24.controller;

import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.exception.DuplicateEmailException;
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

    @GetMapping("/listado")
    public String listadoUsuarios(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
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

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        String strTo = "redirect:/usuario/listado";
        try {
            this.usuarioService.guardarUsuario(usuario);
        } catch (DuplicateEmailException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/crear";
        }
        return strTo;
    }


    @ExceptionHandler(DuplicateEmailException.class)
    public String handleDuplicateEmailException(DuplicateEmailException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "usuario/crear";
    }
}

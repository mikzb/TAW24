package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.exception.UserNotFoundException;
import es.uma.taw24.service.ComidaService;
import es.uma.taw24.service.EjercicioService;
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

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private ComidaService comidaService;



    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/inicio";
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return strTo;
    }

    @GetMapping("/listado")
    public String listadoUsuarios(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/listado";
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.usuarioService.listarUsuarios();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("usuarios", usuarios);
        return strTo;
    }

    @GetMapping("/ejercicios")
    public String listadoEjercicios(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/listadoEjercicio";
        ArrayList<Ejercicio> ejercicios = (ArrayList<Ejercicio>) this.ejercicioService.listarEjercicios();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("ejercicios", ejercicios);
        return strTo;
    }

    @GetMapping("/comidas")
    public String listadoComidas(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/listadoComida";
        ArrayList<Comida> comidas = (ArrayList<Comida>) this.comidaService.listarComidas();
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("comidas", comidas);
        return strTo;
    }


    @PostMapping("/eliminar")
    public String eliminarUsuario(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/usuario/listado";
        try {
            this.usuarioService.eliminarUsuario(id);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/listado";
        }
        return strTo;
    }

    @GetMapping("/crear")
    public String crearUsuario(Model model) {
        String strTo = "usuario/crear";
        model.addAttribute("usuario", new Usuario());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        String strTo = "redirect:/usuario/listado";
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
        String strTo = "redirect:/usuario/listado";
        try {
            this.usuarioService.guardarUsuario(usuario);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/editar";
        }
        return strTo;
    }



}

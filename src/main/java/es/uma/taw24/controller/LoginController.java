package es.uma.taw24.controller;

import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.exception.UserNotFoundException;
import es.uma.taw24.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends BaseController {


    @Autowired
    protected UsuarioService usuarioService;

    @GetMapping("/")
    public String doLogin (Model model, HttpSession session) {
        String strTo = "login";
        if (estaAutenticado(session)) {
            strTo = "redirect:/cliente/";
        } else {
            model.addAttribute("usuario", new Usuario());
        }
        return strTo;
    }

    @PostMapping("/autenticar")
    public String doAutentica (@ModelAttribute("usuario") Usuario usuario,
                               Model model, HttpSession session) {
        String strTo = "redirect:/cliente/";
        try {
            Usuario authenticatedUser = this.usuarioService.autenticar(usuario.getEmail(), usuario.getPassword());
            if (authenticatedUser == null) {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                strTo = this.doLogin(model, session);
            } else {
                session.setAttribute("usuario", authenticatedUser);
            }
        } catch (UserNotFoundException e) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            strTo = this.doLogin(model, session);
        }
        return strTo;
    }


    @GetMapping("/salir")
    public String doSalir (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "login";
    }

}

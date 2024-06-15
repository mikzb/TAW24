package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 95%
 *         Cristian Ruiz Martín: 5%
 */

import es.uma.taw24.DTO.Usuario;
import jakarta.servlet.http.HttpSession;

public class BaseController {

    protected boolean estaAutenticado(HttpSession session) {
        return session.getAttribute("usuario") != null;
    }

    protected boolean esAdmin(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null && usuario.isPermisoAdmin();
    }

    protected boolean esEntrenador(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null && usuario.isPermisoEntrenador();
    }

    protected boolean esDietista(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null && usuario.isPermisoDietista();
    }

    protected boolean esCliente(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null && usuario.isPermisoCliente();
    }

    protected String redirectToLogin() {
        return "redirect:/";
    }

    protected String accessDenied() {
        return "error/403";
    }

    protected String unprocessableEntity() {
        return "error/422";
    }
}

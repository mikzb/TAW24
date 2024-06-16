package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.*;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.service.EntrenadorService;
import es.uma.taw24.service.UsuarioService;
import es.uma.taw24.ui.FiltroUsuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends BaseController{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "usuario/inicio";
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuario", usuario);
        return strTo;
    }

    @GetMapping("/listado")
    public String listar(Model model, HttpSession session){
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
        FiltroUsuario filtro = new FiltroUsuario();
        filtro.setNombre("");
        filtro.setEmail("");
        filtro.setApellidos("");
        filtro.setEdad(null);
        filtro.setSexo("");
        filtro.setPermisoAdmin(false);
        filtro.setPermisoCliente(false);
        filtro.setPermisoDietista(false);
        filtro.setPermisoEntrenador(false);
        model.addAttribute("filtro", filtro);
        return strTo;
    }

    @GetMapping("/borrar")
    public String borrarUsuario(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/usuario/listado";
        try {
            this.usuarioService.borrarUsuario(id);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
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
            Usuario usuario = usuarioService.buscarUsuario(id);
            List<Entrenador> entrenadores = entrenadorService.listarEntrenadores();
            List<Entrenador> entrenadoresAsignados = entrenadorService.listarEntrenadoresDeUsuario(id);
            List<Usuario> dietistas = usuarioService.listarDietistas();

            if (entrenadoresAsignados == null) {
                entrenadoresAsignados = new ArrayList<>();
            }

            if (entrenadores == null) {
                entrenadores = new ArrayList<>();
            }

            if (dietistas == null) {
                dietistas = new ArrayList<>();
            }

            dietistas = dietistas.stream()
                    .filter(dietista -> dietista.getId() != id)
                    .toList();

            List<Integer> assignedEntrenadorIds = entrenadoresAsignados.stream()
                    .map(Entrenador::getId)
                    .toList();

            List<Entrenador> entrenadoresNoAsignados = entrenadores.stream()
                    .filter(entrenador -> !assignedEntrenadorIds.contains(entrenador.getId())).filter(entrenador -> entrenador.getId() != id)
                    .toList();

            EntrenadorUsuario entrenadorUsuario = new EntrenadorUsuario();
            entrenadorUsuario.setUsuarioId(id);
            UsuarioDietistaForm usuarioDietistaForm = new UsuarioDietistaForm();
            usuarioDietistaForm.setUsuarioId(id);
            model.addAttribute("entrenadorusuario", entrenadorUsuario);
            model.addAttribute("entrenadores", entrenadoresNoAsignados);
            model.addAttribute("entrenadoresAsignados", entrenadoresAsignados);
            model.addAttribute("usuario", usuario);
            model.addAttribute("usuarioDietistaForm", usuarioDietistaForm);
            model.addAttribute("dietistas", dietistas);
        } catch (NotFoundException e) {
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
            session.setAttribute("usuario", usuario);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "usuario/editar";
        }
        return strTo;
    }


    @PostMapping("/filtrar")
    public String filtrar (@ModelAttribute("filtro") FiltroUsuario filtro, Model model, HttpSession session) {
        String strTo = "usuario/listado";
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        if (filtro.estaVacio()) {
            strTo = "redirect:/usuario/listado";
        } else {
            List<Usuario> usuarios = this.usuarioService.listarUsuariosPorFiltro(filtro);
            model.addAttribute("usuarios", usuarios);
            model.addAttribute("usuario", session.getAttribute("usuario"));
            model.addAttribute("filtro", filtro);
        }

        return strTo;
    }


}

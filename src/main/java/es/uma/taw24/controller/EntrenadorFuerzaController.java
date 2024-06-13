package es.uma.taw24.controller;

/**
 * @author Cristian Ruiz Martín: 100%
 */

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.service.EntrenadorService;
import es.uma.taw24.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorFuerzaController extends BaseController{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        String strTo = "entrenador/inicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        Entrenador entrenador = entrenadorService.buscarPorId(usuarioEntrenador.getId());
        model.addAttribute("entrenador", entrenador);
        return strTo;
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model, HttpSession session) {
        String strTo = "entrenador/clientes";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        List<Usuario> clientes = usuarioService.listarClientes(usuarioEntrenador.getId());
        model.addAttribute("clientes", clientes);
        return strTo;
    }

    @GetMapping("/cliente/{id}/rutina")
    public String verRutina(Model model, HttpSession session, @PathVariable("id") Integer id) {
        String strTo = "entrenador/rutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        Entrenador entrenador = entrenadorService.buscarPorId(usuarioEntrenador.getId());
        model.addAttribute("entrenador", entrenador);
        Usuario cliente = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("cliente", cliente);
        return strTo;
    }



}

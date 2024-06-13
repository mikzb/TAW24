package es.uma.taw24.controller;

/**
 * @author Cristian Ruiz Martín: 100%
 */

import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.UsuarioEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/entrenadorFuerza")
public class EntrenadorFuerzaController extends BaseController{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        int id = 3;
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        EntrenadorEntity entrenador = entrenadorRepository.findById(usuario.getId()).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "inicioEntrenadorFuerza";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model, @RequestParam Integer idEntrenador) {
        EntrenadorEntity entrenador = entrenadorRepository.findById(idEntrenador).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "clientesFuerza";
    }



}

package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.DTO.EntrenadorUsuario;
import es.uma.taw24.service.EntrenadorService;
import es.uma.taw24.service.EntrenadorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entrenadorusuario")
public class EntrenadorUsuarioController extends BaseController {
    @Autowired
    private EntrenadorUsuarioService entrenadorUsuarioService;

    @PostMapping("/asignar")
    public String asignarEntrenador(EntrenadorUsuario entrenadorUsuario) {
        entrenadorUsuarioService.asignarEntrenadorUsuario(entrenadorUsuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/desasignar")
    public String desasignarEntrenador(@RequestParam("idUsuario") int idUsuario, @RequestParam("idEntrenador") int idEntrenador) {
        entrenadorUsuarioService.desasignarEntrenadorUsuario(idUsuario, idEntrenador);
        return "redirect:/usuario/listado";
    }
}

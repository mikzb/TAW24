package es.uma.taw24.controller;

//Cristian Ruiz Martín : 100%

import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entrenadorFuerza")
public class EntrenadorFuerzaController extends BaseController{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping("/inicioEntrenadorFuerza")
    public String doInicio(Model model) {
        int id = 3;
        UsuarioEntity usuario = usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario_entrenador", usuario);
        return "inicioEntrenadorFuerza";
    }



}

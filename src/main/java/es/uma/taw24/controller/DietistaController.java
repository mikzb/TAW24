/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.controller;

import es.uma.taw24.dao.DietaRepository;
import es.uma.taw24.dao.UsuarioDietaRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.DietaEntity;
import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.entity.UsuarioDietaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DietistaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private UsuarioDietaRepository usuarioDietaRepository;

    @GetMapping("/")
    public String doInicio() {
        return "inicioDietista";
    }

    @GetMapping("/dietas")
    public String doDietas(Model model) {
        List<DietaEntity> dietas = this.dietaRepository.findAll();

        model.addAttribute("dietas", dietas);

        return "dietas";
    }


    @GetMapping("/dietaDietista")
    public String doDieta(Model model) {
        return "dietaDietista";
    }

    @GetMapping("/crearDieta")
    public String doCrearDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/guardarDieta")
    public String doGuardarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/importarDieta")
    public String doImportarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/borrarDieta")
    public String doBorrarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/clientesDietista")
    public String doClientes(Model model) {
        List<UsuarioEntity> clientes = this.usuarioRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "clientesDietista";
    }

    @GetMapping("/verDietaAsignada")
    public String doVerDietaAsignada(Model model, @RequestParam("id") Integer id) {
        UsuarioDietaEntity usuarioDieta = this.usuarioDietaRepository.findByUsuarioId(id);
        DietaEntity dieta = usuarioDieta.getIddieta();

        model.addAttribute("dieta", dieta);

        return "verDietaAsignadaDietista";
    }
}

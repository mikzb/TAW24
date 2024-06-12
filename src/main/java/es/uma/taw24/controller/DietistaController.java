/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.controller;

import es.uma.taw24.dao.*;
import es.uma.taw24.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private DietaDiaRepository dietaDiaRepository;

    @GetMapping("/")
    public String doInicio() {
        return "./Dietista/inicioDietista";
    }

    @GetMapping("/dietas")
    public String doDietas(Model model) {
        List<DietaEntity> dietas = this.dietaRepository.findAll();

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }


    @GetMapping("/dietaDietista")
    public String doDieta(Model model) {
        return "./Dietista/dietaDietista";
    }

    @GetMapping("/crearDieta")
    public String doCrearDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/editarDieta")
    public String doEditarDieta(Model model) {

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        List<Comida> comidas = this.comidaRepository.findAll();
        model.addAttribute("comidas", comidas);

        return "redirect:/";
    }

    @PostMapping("/guardarDieta")
    public String doGuardarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/importarDieta")
    public String doImportarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/eliminarDieta")
    public String doEliminarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/clientesDietista")
    public String doClientes(Model model) {
        List<Usuario> clientes = this.usuarioRepository.findAll();
        model.addAttribute("clientes", clientes);

        return "./Dietista/clientesDietista";
    }

    @GetMapping("/verDietaCreada")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer id) {
        List<DietaDia> dietaDia = this.dietaDiaRepository.findByDietaId(id);

        if (dietaDia.isEmpty()) {
            System.err.println("Dieta sin dias");
        } else if (dietaDia.size() > 7) {
            System.err.println("Dieta con mas dias de los necesarios");
        } else {
            int lunesId = dietaDia.get(0).getIddia().getId();
            int martesId = dietaDia.get(1).getIddia().getId();
            int miercolesId = dietaDia.get(2).getIddia().getId();
            int juevesId = dietaDia.get(3).getIddia().getId();
            int viernesId = dietaDia.get(4).getIddia().getId();
            int sabadoId = dietaDia.get(5).getIddia().getId();
            int domingoId = dietaDia.get(6).getIddia().getId();
        }

        

        return "./Dietista/verDietaCreadaDietista";
    }

    @GetMapping("/verDietaAsignada")
    public String doVerDietaAsignada(Model model, @RequestParam("id") Integer id) {
        UsuarioDietaEntity usuarioDieta = this.usuarioDietaRepository.findByUsuarioId(id);
        DietaEntity dieta = usuarioDieta.getIddieta();

        model.addAttribute("dieta", dieta);

        return "./Dietista/verDietaAsignadaDietista";
    }
}

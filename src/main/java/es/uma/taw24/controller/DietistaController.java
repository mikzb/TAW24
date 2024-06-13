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

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private MenuDiaRepository menuDiaRepository;

    @Autowired
    private ComidaMenuRepository comidaMenuRepository;

    @GetMapping("/")
    public String doInicio() {
        return "./Dietista/inicioDietista";
    }

    //TODO: FALTA EL ID DEL DIETISTA
    @GetMapping("/dietas")
    public String doDietas(Model model) {
        List<DietaEntity> dietas = this.dietaRepository.findAll();

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }

    //TODO
    @GetMapping("/crearDieta")
    public String doCrearDieta(Model model) {

        ComidaEntity[] comidasDieta = new ComidaEntity[35];
        for (int i = 0; i < 35; i++) {
            comidasDieta[i] = new ComidaEntity();
        }
        model.addAttribute("comidasDieta", comidasDieta);

        List<ComidaEntity> comidas = this.comidaRepository.findAll();
        model.addAttribute("comidas", comidas);

        return "./Dietista/crearDieta";
    }

    //TODO
    @GetMapping("/editarDieta")
    public String doEditarDieta(Model model) {

        DietaEntity dieta = new DietaEntity();
        model.addAttribute("dieta", dieta);

        List<ComidaEntity> comidas = this.comidaRepository.findAll();
        model.addAttribute("comidas", comidas);

        return "redirect:/";
    }

    //TODO
    @PostMapping("/guardarDieta")
    public String doGuardarDieta(@RequestParam("comidas") List<ComidaEntity> comidas) {



        return "redirect:/dietas";
    }

    //TODO
    @GetMapping("/eliminarDieta")
    public String doEliminarDieta(Model model) {
        return "redirect:/";
    }

    //TODO: FALTA EL ID DEL DIETISTA
    @GetMapping("/clientesDietista")
    public String doClientes(Model model) {
        List<UsuarioEntity> clientes = this.usuarioRepository.findAll();
        model.addAttribute("clientes", clientes);

        return "./Dietista/clientesDietista";
    }

    @GetMapping("/cargarDietaDietista")
    public String doCargarDieta(@RequestParam("id") Integer id) {
        UsuarioDietaEntity usuarioDieta = this.usuarioDietaRepository.findByUsuarioId(id);
        Integer dietaId = usuarioDieta.getIddieta().getId();

        return "redirect:/verDietaDietista?id=" + dietaId;
    }

    @GetMapping("/verDietaDietista")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer id) {

        // Obtener los días de la dieta
        List<DietaDiaEntity> dietaDia = this.dietaDiaRepository.findByDietaId(id);

        if (dietaDia.isEmpty()) {
            System.err.println("Dieta sin días");
            return "errorPage"; // O la vista que corresponda en caso de error
        }

        // Preparar una lista para almacenar los menús de cada día
        Map<Instant, List<String>> menusPorDia = new HashMap<>();

        // Iterar sobre los días de la dieta
        for (DietaDiaEntity dietaDiaEntity : dietaDia) {
            DiaEntity dia = dietaDiaEntity.getIddia();
            int diaId = dia.getId();

            // Obtener los menús del día
            MenuDiaEntity menuDiaEntity = this.menuDiaRepository.findByDiaId(diaId);
            List<String> comidas = new ArrayList<>();

            int menuId = menuDiaEntity.getIdmenu().getId();

            // Obtener las comidas del menú
            List<ComidaMenuEntity> comidaMenuEntities = this.comidaMenuRepository.findByMenuId(menuId);
            for (ComidaMenuEntity comidaMenuEntity : comidaMenuEntities) {
                comidas.add(comidaMenuEntity.getIdcomida().getDescripcion());
            }

            // Almacenar las comidas en el mapa con el nombre del día
            menusPorDia.put(dia.getFecha(), comidas);
        }

        model.addAttribute("dietaId", id);
        // Agregar los menús por día al modelo para ser usado en la vista
        model.addAttribute("menus", menusPorDia);

        return "./Dietista/verDietaDietista";
    }
}

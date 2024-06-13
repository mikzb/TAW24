/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.controller;

import es.uma.taw24.dao.*;
import es.uma.taw24.entity.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dietista")
public class DietistaController extends BaseController {

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
    public String doDietas(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        List<DietaEntity> dietas = this.dietaRepository.findAll();

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }

    //TODO
    @GetMapping("/crearDieta")
    public String doCrearDieta(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        List<ComidaEntity> comidasDieta = new ArrayList<>(35);
        for (int i = 0; i < 35; i++) {
            comidasDieta.add(new ComidaEntity());
        }
        model.addAttribute("comidasDieta", comidasDieta);

        List<ComidaEntity> comidas = this.comidaRepository.findAll();
        model.addAttribute("comidas", comidas);

        return "./Dietista/crearDieta";
    }

    //TODO
    @GetMapping("/editarDieta")
    public String doEditarDieta(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        DietaEntity dieta = new DietaEntity();
        model.addAttribute("dieta", dieta);

        List<ComidaEntity> comidas = this.comidaRepository.findAll();
        model.addAttribute("comidas", comidas);

        return "redirect:/";
    }

    //TODO
    @PostMapping("/guardarDieta")
    public String doGuardarDieta(@RequestParam("comidas") List<ComidaEntity> comidas, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        return "redirect:/dietas";
    }

    //TODO: FALTA EL ID DEL DIETISTA
    @GetMapping("/eliminarDieta")
    public String doEliminarDieta(@RequestParam("id") Integer id, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        List<DietaDiaEntity> dietaDias = this.dietaDiaRepository.findByDietaId(id);
        this.dietaDiaRepository.deleteAll(dietaDias);

        List<UsuarioDietaEntity> usuarioDietas = this.usuarioDietaRepository.findByDietaId(id);
        this.usuarioDietaRepository.deleteAll(usuarioDietas);

        this.dietaRepository.deleteById(id);

        return "redirect:/dietas";
    }

    //TODO: FALTA EL ID DEL DIETISTA
    @GetMapping("/clientesDietista")
    public String doClientes(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        List<UsuarioEntity> clientes = this.usuarioRepository.findAll();
        model.addAttribute("clientes", clientes);

        return "./Dietista/clientesDietista";
    }

    @GetMapping("/verDietaDietista")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer id, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        // Obtener los días de la dieta
        List<DietaDiaEntity> dietaDia = this.dietaDiaRepository.findByDietaId(id);

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

        DietaEntity dieta = this.dietaRepository.findById(id).get();
        model.addAttribute("dieta", dieta);

        // Agregar los menús por día al modelo para ser usado en la vista
        model.addAttribute("menus", menusPorDia);

        return "./Dietista/verDietaDietista";
    }

    @GetMapping("/verProgresoDieta")
    public String doVerProgresoDieta(@RequestParam("id") Integer id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        UsuarioDietaEntity usuarioDieta = this.usuarioDietaRepository.findByUsuarioId(id);
        DietaEntity dieta = usuarioDieta.getIddieta();
        model.addAttribute("dieta", dieta);

        // Obtener los días de la dieta
        List<DietaDiaEntity> dietaDia = this.dietaDiaRepository.findByDietaId(dieta.getId());

        // Preparar una lista para almacenar los menús de cada día
        Map<Instant, List<String>> menusPorDia = new HashMap<>();

        // Preparar lista para completado
        List<Boolean> completados = new ArrayList<>();

        // Iterar sobre los días de la dieta
        for (DietaDiaEntity dietaDiaEntity : dietaDia) {
            DiaEntity dia = dietaDiaEntity.getIddia();
            int diaId = dia.getId();

            // Obtener los menús del día
            MenuDiaEntity menuDiaEntity = this.menuDiaRepository.findByDiaId(diaId);
            completados.add(menuDiaEntity.getCompletado());
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

        // Agregar al modelo
        model.addAttribute("menus", menusPorDia);
        model.addAttribute("completados", completados);

        return "./Dietista/verProgresoDieta";
    }

    @GetMapping("/cambiarDietaDietista")
    public String doCambiarDieta(@RequestParam("id") Integer id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        model.addAttribute("usuarioId", id);

        List<DietaEntity> dietas = this.dietaRepository.findAll();
        model.addAttribute("dietas", dietas);

        DietaEntity dieta = new DietaEntity();
        model.addAttribute("dieta", dieta);

        return "./Dietista/cambiarDietaDietista";
    }

    //TODO: FALTA EL ID DEL DIETISTA
    @PostMapping("/guardarCambioDieta")
    public String doGuardarCambioDieta(@RequestParam("usuarioId") Integer usuarioId, @ModelAttribute("dieta") DietaEntity dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        DietaEntity dieta = this.dietaRepository.findById(dietaId.getId()).orElse(null);

        this.usuarioDietaRepository.updateDieta(usuarioId, dieta);

        return "redirect:/clientesDietista";
    }
}

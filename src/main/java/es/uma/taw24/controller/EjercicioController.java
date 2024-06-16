package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */


import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.EjercicioGrupomuscular;
import es.uma.taw24.DTO.GrupoMuscular;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.service.EjercicioService;
import es.uma.taw24.service.EjerciciogrupomuscularService;
import es.uma.taw24.service.GrupoMuscularService;
import es.uma.taw24.service.TipoService;
import es.uma.taw24.ui.FiltroEjercicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController extends BaseController{

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private TipoService tipoService;

    @Autowired
    private GrupoMuscularService grupomuscularService;

    @Autowired
    private EjerciciogrupomuscularService ejerciciogrupomuscularService;

    @GetMapping("/listado")
    public String listar(Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/listado";
        ArrayList<Ejercicio> ejercicios = (ArrayList<Ejercicio>) this.ejercicioService.listarEjercicios();
        Map<Integer, List<GrupoMuscular>> gruposPorEjercicio = ejercicios.stream().collect(Collectors.toMap(
                Ejercicio::getId,
                ejercicio -> grupomuscularService.buscarGrupomuscularPorEjercicio(ejercicio.getId())));
        if (gruposPorEjercicio.isEmpty()) {
            gruposPorEjercicio = new HashMap<>();
        }
        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("ejercicios", ejercicios);
        model.addAttribute("gruposPorEjercicio", gruposPorEjercicio);

        FiltroEjercicio filtro = new FiltroEjercicio();
        filtro.setNombre("");
        filtro.setTipo("");
        filtro.setGrupoMuscular("");
        model.addAttribute("filtro", filtro);
        return strTo;
    }

    @GetMapping("/editar")
    public String editarEjercicio(@RequestParam("id") int id, Model model, HttpSession session){
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/editar";
        Ejercicio ejercicio = this.ejercicioService.buscarPorId(id);
        List<GrupoMuscular> gruposmusculares = this.grupomuscularService.listarGruposMusculares();
        List<GrupoMuscular> gruposmuscularesAsignados = this.grupomuscularService.buscarGrupomuscularPorEjercicio(id);

        if (gruposmusculares == null) {
            gruposmusculares = new ArrayList<>();
        }
        if (gruposmuscularesAsignados == null) {
            gruposmuscularesAsignados = new ArrayList<>();
        }

        model.addAttribute("usuario", session.getAttribute("usuario"));
        model.addAttribute("tipos", this.tipoService.listarTipos());
        model.addAttribute("ejercicio", ejercicio);
        model.addAttribute("gruposmusculares",gruposmusculares);
        model.addAttribute("gruposmuscularesAsignados",gruposmuscularesAsignados);
        return strTo;
    }

    @PostMapping("/editar")
    public String editarEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio, @RequestParam(value = "gruposMuscularesIds", required = false) List<Integer> gruposMuscularesIds, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {

            this.ejercicioService.guardarEjercicio(ejercicio);

            Set<Integer> newGruposIds = new HashSet<>(gruposMuscularesIds != null ? gruposMuscularesIds : new ArrayList<>());

            List<GrupoMuscular> gruposAssignados = this.grupomuscularService.buscarGrupomuscularPorEjercicio(ejercicio.getId());
            Set<Integer> gruposAssignadosIds = gruposAssignados.stream()
                    .map(GrupoMuscular::getId)
                    .collect(Collectors.toSet());

            // Assign new groups
            for (Integer id : newGruposIds) {
                if (!gruposAssignadosIds.contains(id)) {
                    EjercicioGrupomuscular ejercicioGrupomuscular = new EjercicioGrupomuscular();
                    ejercicioGrupomuscular.setEjercicioId(ejercicio.getId());
                    ejercicioGrupomuscular.setGrupomuscularId(id);
                    this.ejerciciogrupomuscularService.asignarEjercicioGrupo(ejercicioGrupomuscular);
                }
            }

            // Unassign removed groups
            for (Integer id : gruposAssignadosIds) {
                if (!newGruposIds.contains(id)) {
                    this.ejerciciogrupomuscularService.desasignarEjercicioGrupo(ejercicio.getId(), id);
                }
            }

            if (gruposMuscularesIds != null) {
                for (Integer id : gruposMuscularesIds) {
                    EjercicioGrupomuscular ejercicioGrupomuscular = new EjercicioGrupomuscular();
                    ejercicioGrupomuscular.setEjercicioId(ejercicio.getId());
                    ejercicioGrupomuscular.setGrupomuscularId(id);
                    this.ejerciciogrupomuscularService.asignarEjercicioGrupo(ejercicioGrupomuscular);
                }
            }
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "ejercicio/editar";
        }
        return strTo;
    }

    @GetMapping("/borrar")
    public String borrarEjercicio(@RequestParam("id") int id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {
            this.ejercicioService.borrarEjercicio(id);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return strTo;
    }

    @GetMapping("/crear")
    public String crearEjercicio(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "ejercicio/crear";
        model.addAttribute("tipos", this.tipoService.listarTipos());
        model.addAttribute("ejercicio", new Ejercicio());
        return strTo;
    }

    @PostMapping("/crear")
    public String crearEjercicio(@ModelAttribute("comida") Ejercicio ejercicio, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }

        if (!esAdmin(session)) {
            return accessDenied();
        }
        String strTo = "redirect:/ejercicio/listado";
        try {
            this.ejercicioService.guardarEjercicio(ejercicio);
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            strTo = "ejercicio/crear";
        }
        return strTo;
    }

    @PostMapping("/filtrar")
    public String filtrar (@ModelAttribute("filtro") FiltroEjercicio filtro, Model model, HttpSession session) {
        String strTo = "ejercicio/listado";
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esAdmin(session)) {
            return accessDenied();
        }
        if (filtro.estaVacio()) {
            strTo = "redirect:/ejercicio/listado";
        } else {
            List<Ejercicio> ejercicios = this.ejercicioService.listarEjerciciosPorFiltro(filtro);
            Map<Integer, List<GrupoMuscular>> gruposPorEjercicio = ejercicios.stream().collect(Collectors.toMap(
                    Ejercicio::getId,
                    ejercicio -> grupomuscularService.buscarGrupomuscularPorEjercicio(ejercicio.getId())));
            if (gruposPorEjercicio.isEmpty()) {
                gruposPorEjercicio = new HashMap<>();
            }
            model.addAttribute("ejercicios", ejercicios);
            model.addAttribute("gruposPorEjercicio", gruposPorEjercicio);
            model.addAttribute("usuario", session.getAttribute("usuario"));
            model.addAttribute("filtro", filtro);
        }

        return strTo;
    }

}

package es.uma.taw24.controller;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.EjercicioGrupomuscular;
import es.uma.taw24.service.EjerciciogrupomuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ejerciciogrupomuscular")
public class EjercicioGrupomuscularController extends BaseController {
    @Autowired
    private EjerciciogrupomuscularService ejerciciogrupomuscularService;

    @PostMapping("/asignar")
    public String asignarGrupo(EjercicioGrupomuscular ejercicioGrupomuscular) {
        ejerciciogrupomuscularService.asignarEjercicioGrupo(ejercicioGrupomuscular.getEjercicioId(), ejercicioGrupomuscular.getGrupomuscularId());
        return "redirect:/ejercicio/listado";
    }

    @GetMapping("/desasignar")
    public String desasignarGrupo(@RequestParam("idEjercicio") int idEjercicio, @RequestParam("idGrupomuscular") int idGrupomuscular) {
        ejerciciogrupomuscularService.desasignarEjercicioGrupo(idEjercicio, idGrupomuscular);
        return "redirect:/ejercicio/listado";
    }
}

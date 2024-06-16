/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import es.uma.taw24.DTO.*;
import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.MenuDiaIdEntity;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.service.DietaService;
import es.uma.taw24.service.MenuDiaService;
import es.uma.taw24.service.RutinaService;
import es.uma.taw24.service.SesionEjercicioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

import java.time.ZoneOffset;
import java.util.List;


@Controller


@RequestMapping("/cliente")
public class ClienteController extends BaseController{

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private SesionEjercicioService sesionEjercicioService;

    @Autowired
    private DietaService dietaService;

    @Autowired
    private MenuDiaService menuDiaService;

    @Autowired
    private ComidaRepository comidaRepository; //does this go here?

    @GetMapping("/")
    public String doInicio(HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }
        return "inicioCliente";
    }

    @GetMapping("/dietaCliente")
    public String doDietaCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }
    // TODO : que la fecha sea la actual, ahora no esta pq no hay dietas para hoy xd
        Usuario cliente = (Usuario) session.getAttribute("usuario");
        Integer clienteId = cliente.getId();
        model.addAttribute("usuario", cliente);
        Instant fecha = LocalDate.of(2024, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);
        List<ComidaEntity> comidas = comidaRepository.findComidasByClienteId(Long.valueOf(clienteId),fecha);
        model.addAttribute("comidas", comidas);

        return "dietaCliente";
    }

    @GetMapping("/dietasCliente")
    public String doDietas(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Dieta> dietas = this.dietaService.findDietasByClienteId(usuario.getId());
        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        model.addAttribute("dietas", dietas);

        return "dietasCliente";
    }

    @PostMapping("/filtrarDietasCliente")
    public String doFiltrarDietas(@ModelAttribute("dieta") Dieta dietaD, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Dieta> dietas = this.dietaService.findDietasByClienteIdByDescripcion(usuario.getId(), dietaD.getDescripcion());

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        model.addAttribute("dietas", dietas);

        return "dietasCliente";
    }

    @GetMapping("/verDietaCliente")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dieta = this.dietaService.cargarDietaPorDietaId(dietaId);
        model.addAttribute("dieta", dieta);

        return "verDietaCliente";
    }


    @GetMapping("/entrenamientoCliente")
    public String getRutinasCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario cliente = (Usuario) session.getAttribute("usuario");
        List<RutinaEntity> rutinas = rutinaService.findRutinasByClienteId(cliente.getId());
        model.addAttribute("rutinas", rutinas);

        return "entrenamientoCliente";
    }

    @GetMapping("/rutinaDetalle")
    public String getRutinaDetalle(@RequestParam Integer rutinaId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Rutina rutina = rutinaService.buscarRutina(rutinaId);
        List<SesionEjercicio> sesionEjercicios = sesionEjercicioService.findSesionEjerciciosByRutinaId(rutinaId);
        model.addAttribute("rutina", rutina);
        model.addAttribute("sesionEjercicios", sesionEjercicios);

        return "rutinaDetalle";
    }

    @PostMapping("/updateCompletado")
    public String updateCompletado(@RequestParam Integer rutinaID, @RequestParam Integer sesionEjercicioId, @RequestParam Integer ejercicioId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        SesionEjercicio sesionEjercicio = (SesionEjercicio) sesionEjercicioService.buscarSesionEjercicioPorIdSesionYEjercicio(sesionEjercicioId, ejercicioId);
        sesionEjercicio.setCompletado(!sesionEjercicio.isCompletado());
        sesionEjercicioService.guardar(sesionEjercicio);

        return "redirect:/cliente/rutinaDetalle?rutinaId=" + rutinaID;
    }

    @PostMapping("/completarDia")
    public String completarDia(@RequestParam Integer diaId, @RequestParam Integer menuId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario cliente = (Usuario) session.getAttribute("usuario");
        Integer clienteId = cliente.getId();

        MenuDiaIdEntity menuDiaId = new MenuDiaIdEntity();
        menuDiaId.setIdmenu(menuId);
        menuDiaId.setIddia(diaId);

        MenuDia menuDia = (MenuDia) menuDiaService.findMenuDiaByDiaIdAndMenuId(menuDiaId);
        menuDia.setCompletado(true);
        menuDiaService.guardar(menuDia, menuDiaId);


        return "redirect:/cliente/verDietaCliente?id=" + clienteId;
    }



}

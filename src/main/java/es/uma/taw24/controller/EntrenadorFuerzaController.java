package es.uma.taw24.controller;

/**
 * @author Cristian Ruiz Martín: 100%
 */

import es.uma.taw24.DTO.*;
import es.uma.taw24.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorFuerzaController extends BaseController{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private RutinaSesionService rutinaSesionService;

    @Autowired
    private SesionEjercicioService sesionEjercicioService;

    @Autowired
    private SesionService sesionService;

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        String strTo = "entrenador/inicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        Entrenador entrenador = entrenadorService.buscarEntrenador(usuarioEntrenador.getId());
        model.addAttribute("entrenador", entrenador);
        return strTo;
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model, HttpSession session) {
        String strTo = "entrenador/clientes";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        List<Usuario> clientes = usuarioService.listarClientes(usuarioEntrenador.getId());
        model.addAttribute("clientes", clientes);
        return strTo;
    }

    @GetMapping("/cliente/{id}/rutinas")
    public String verRutina(Model model, HttpSession session, @PathVariable("id") Integer id) {
        String strTo = "entrenador/rutinas";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        List<Rutina> rutinas = rutinaService.listarRutinas(id, usuarioEntrenador.getId());
        model.addAttribute("rutinas", rutinas);
        return strTo;
    }

    @GetMapping("/rutinas")
    public String listarRutinas(Model model, HttpSession session) {
        String strTo = "entrenador/rutinas";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        List<Rutina> rutinas = rutinaService.listarRutinas(usuarioEntrenador.getId());
        model.addAttribute("rutinas", rutinas);
        return strTo;
    }

    @GetMapping("/rutina")
    public String verRutina(@RequestParam("id") Integer id, Model model, HttpSession session) {
        String strTo = "entrenador/rutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        List<RutinaSesion> rutinaSesiones = rutinaSesionService.buscarPorIdRutina(id);
        model.addAttribute("rutinaSesiones", rutinaSesiones);

        return strTo;
    }

    @GetMapping("/sesion")
    public String verSesion(@RequestParam("id") Integer id, Model model, HttpSession session) {
        String strTo = "entrenador/sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        List<SesionEjercicio> sesionEjercicios = sesionEjercicioService.buscarSesionEjercicioPorIdSesion(id);
        model.addAttribute("sesionEjercicios", sesionEjercicios);
        return strTo;
    }

    @GetMapping("/sesion/{id}/anyadir")
    public String anyadirEjercicioSesion(@PathVariable("id") Integer id, Model model, HttpSession session) {
        String strTo = "entrenador/nuevo_ejercicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        SesionEjercicio sesionEjercicio = new SesionEjercicio();
        Sesion sesion = sesionService.buscarSesion(id);
        List<Ejercicio> ejercicios = ejercicioService.buscarEjerciciosPorTipo("Fuerza");
        Ejercicio ejercicio = new Ejercicio();
        sesionEjercicio.setSesion(sesion);
        sesionEjercicio.setEjercicio(ejercicio);
        model.addAttribute("ejercicios", ejercicios);
        model.addAttribute("sesionEjercicio", sesionEjercicio);
        return strTo;
    }



}

package es.uma.taw24.controller;

/**
 * @author Cristian Ruiz Martín: 100%
 */

import es.uma.taw24.DTO.*;
import es.uma.taw24.service.*;
import es.uma.taw24.ui.FiltroRutina;
import es.uma.taw24.ui.FiltroSesionEjercicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
    private RutinaUsuarioService rutinaUsuarioService;

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
        model.addAttribute("filtro", new FiltroRutina());
        model.addAttribute("rutinas", rutinas);
        model.addAttribute("idCliente", id);
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
        List<Usuario> clientes = usuarioService.listarClientes(usuarioEntrenador.getId());

        model.addAttribute("cliente", new Usuario());
        model.addAttribute("filtro", new FiltroRutina());
        model.addAttribute("clientes", clientes);
        model.addAttribute("rutinas", rutinas);
        return strTo;
    }

    @PostMapping("/rutinas/filtrar")
    public String filtrarRutinas(@ModelAttribute("filtro") FiltroRutina filtro, Model model, HttpSession session) {
        String strTo = "entrenador/rutinas";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        if(filtro.estaVacio()){
            return "redirect:/entrenador/rutinas";
        }


        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        List<Rutina> rutinas;
        if(filtro.getIdCliente() == 0){
            rutinas = rutinaService.listarRutinasPorFiltroSinCliente(usuarioEntrenador.getId(), filtro);
        }
        else {
             rutinas = rutinaService.listarRutinasPorFiltro(usuarioEntrenador.getId(), filtro);
        }
        List<Usuario> clientes = usuarioService.listarClientes(usuarioEntrenador.getId());



        model.addAttribute("cliente", new Usuario());
        model.addAttribute("filtro", filtro);
        model.addAttribute("clientes", clientes);
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
        List<RutinaSesion> rutinaSesiones = rutinaSesionService.buscarRutinaSesion(id);
        model.addAttribute("idRutina", id);
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

        FiltroSesionEjercicio filtro = new FiltroSesionEjercicio();
        filtro.setIdSesion(id);

        model.addAttribute("filtro", filtro);
        model.addAttribute("sesionEjercicios", sesionEjercicios);
        return strTo;
    }

    @PostMapping("/sesion/filtrar")
    public String filtrarSesiones(@ModelAttribute("filtro") FiltroSesionEjercicio filtro, Model model, HttpSession session) {
        String strTo = "entrenador/sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        if(filtro.estaVacio()){
            return "redirect:/entrenador/sesion?id=" + filtro.getIdSesion();
        }

        List<SesionEjercicio> sesionEjercicios = sesionEjercicioService.buscarSesionEjercicioPorFiltro(filtro);

        model.addAttribute("filtro", filtro);
        model.addAttribute("sesionEjercicios", sesionEjercicios);
        return strTo;
    }

    @GetMapping("/sesion/{id}/ejercicio/anyadir")
    public String anyadirSesionEjercicio(@PathVariable("id") Integer id, Model model, HttpSession session) {
        String strTo = "entrenador/ejercicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        SesionEjercicio sesionEjercicio = new SesionEjercicio();
        Sesion sesion = sesionService.buscarSesion(id);
        Ejercicio ejercicio = new Ejercicio();

        sesionEjercicio.setSesion(sesion);
        sesionEjercicio.setEjercicio(ejercicio);

        List<Ejercicio> ejercicios = ejercicioService.buscarEjerciciosNoContenidosEnSesionPorTipo(id, "Fuerza");



        model.addAttribute("ejercicios", ejercicios);
        model.addAttribute("sesionEjercicio", sesionEjercicio);
        return strTo;
    }

    @GetMapping("/sesion/ejercicio/editar")
    public String editarSesionEjercicio(@RequestParam("idSesion") Integer idSesion, @RequestParam("idEjercicio") Integer idEjercicio, Model model, HttpSession session) {
        String strTo = "entrenador/ejercicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        SesionEjercicio sesionEjercicio = sesionEjercicioService.buscarSesionEjercicioPorIdSesionYEjercicio(idSesion, idEjercicio);

        model.addAttribute("sesionEjercicio", sesionEjercicio);
        return strTo;
    }

    @GetMapping("/sesion/crear")
    public String crearSesion(@RequestParam("idRutina") Integer idRutina, Model model, HttpSession session) {
        String strTo = "entrenador/datos_sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        RutinaSesion rutinaSesion = new RutinaSesion();
        Sesion sesion = new Sesion();
        Rutina rutina = rutinaService.buscarRutina(idRutina);

        sesion.setCrosstraining(false);

        rutinaSesion.setRutina(rutina);
        rutinaSesion.setSesion(sesion);

        model.addAttribute("rutinaSesion", rutinaSesion);
        return strTo;
    }

    @GetMapping("/sesion/editar")
    public String crearSesion(@RequestParam("idRutina") Integer idRutina, @RequestParam("idSesion") Integer idSesion, Model model, HttpSession session) {
        String strTo = "entrenador/datos_sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        RutinaSesion rutinaSesion = rutinaSesionService.buscarRutinaSesion(idRutina, idSesion);
        model.addAttribute("rutinaSesion", rutinaSesion);
        return strTo;
    }

    @PostMapping("/sesion/ejercicio/guardar")
    public String guardarEjercicioSesion(@ModelAttribute("sesionEjercicio") SesionEjercicio sesionEjercicio, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        sesionEjercicioService.guardar(sesionEjercicio);
        return "redirect:/entrenador/sesion?id=" + sesionEjercicio.getSesion().getId();
    }

    @PostMapping("/sesion/guardar")
    public String guardarRutinaSesion(@ModelAttribute("RutinaSesion") RutinaSesion rutinaSesion, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        if(rutinaSesionService.contarRutinaSesionPorDia(rutinaSesion.getRutina().getId(), rutinaSesion.getDiadesemana()) > 0){
            return unprocessableEntity();
        }

        rutinaSesionService.guardar(rutinaSesion);
        return "redirect:/entrenador/rutina?id=" + rutinaSesion.getRutina().getId();
    }

    @GetMapping("/sesion/borrar")
    public String borrarRutinaSesion(@RequestParam("idRutina") Integer idRutina, @RequestParam("idSesion") Integer idSesion, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        sesionService.borrarSesion(idSesion);
        return "redirect:/entrenador/rutina?id=" + idRutina;
    }

    @GetMapping("/sesion/ejercicio/borrar")
    public String borrarEjercicioSesion(@RequestParam("idSesion") Integer idSesion, @RequestParam("idEjercicio") Integer idEjercicio, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        sesionEjercicioService.borrarSesionEjercicio(idSesion, idEjercicio);
        return "redirect:/entrenador/sesion?id=" + idSesion;
    }
    @GetMapping("/rutina/anyadir")
    public String anyadirRutina(@RequestParam("idCliente") Integer idCliente, Model model, HttpSession session) {
        String strTo = "redirect:/entrenador/cliente/" + idCliente + "/rutinas";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        Usuario cliente = usuarioService.buscarUsuario(idCliente);
        Rutina rutina = new Rutina();

        Usuario usuarioEntrenador = (Usuario) session.getAttribute("usuario");
        Entrenador entrenador = entrenadorService.buscarEntrenador(usuarioEntrenador.getId());

        rutina.setEntrenador(entrenador);

        RutinaUsuario rutinaUsuario = new RutinaUsuario();

        rutinaUsuario.setUsuario(cliente);
        rutinaUsuario.setRutina(rutina);

        rutinaUsuarioService.guardar(rutinaUsuario);

        return strTo;
    }

    @PostMapping("/rutina/crear")
    public String crearRutina(@ModelAttribute("cliente") Usuario cliente, HttpSession session) {
        String strTo = "redirect:/entrenador/rutina/anyadir?idCliente=" + cliente.getId();;
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }


        return strTo;
    }

//    @GetMapping("/rutina/editar")
//    public String editarRutina(@RequestParam("id") Integer id, Model model, HttpSession session) {
//        String strTo = "entrenador/datos_rutina";
//        if(!estaAutenticado(session)){
//            return redirectToLogin();
//        }
//        if (!esEntrenador(session)) {
//            return accessDenied();
//        }
//
//        Rutina rutina = rutinaService.buscarRutina(id);
//        model.addAttribute("rutina", rutina);
//        return strTo;
//    }

    @GetMapping("/rutina/borrar")
    public String borrarRutina(@RequestParam("id") Integer id, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        rutinaService.borrarRutina(id);
        return "redirect:/entrenador/rutinas";
    }

    @GetMapping("/cliente/rutina/borrar")
    public String borrarRutina(@RequestParam("idRutina") Integer idRutina, @RequestParam("idCliente") Integer idCliente, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        rutinaService.borrarRutina(idRutina);
        return "redirect:/entrenador/cliente/"+idCliente+"/rutinas";
    }

    @PostMapping("/rutina/guardar")
    public String guardarRutina(@ModelAttribute("rutina") RutinaUsuario rutinaUsuario, HttpSession session) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        rutinaUsuarioService.guardar(rutinaUsuario);
        return "redirect:/entrenador/rutinas";
    }
}

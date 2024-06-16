/*
        Alvaro Acedo Espejo 100%
 */

package es.uma.taw24.controller;

import es.uma.taw24.DTO.*;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.entity.*;
import es.uma.taw24.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/entrenadorCross")
public class CrossController extends BaseController{

    @Autowired
    protected EntrenadorService entrenadorService;
    @Autowired
    protected RutinaSesionService rutinaSesionService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RutinaService rutinaService;
    @Autowired
    private RutinaUsuarioService rutinaUsuarioService;
    @Autowired
    private EjercicioService ejercicioService;
    @Autowired
    private SesionService sesionService;
    @Autowired
    private SesionEjercicioService sesionEjercicioService;
    @Autowired
    private RutinaRepository rutinaRepository;

    @GetMapping("/")
    public String doInicio(Model model, HttpSession session) {
        String strTo = "entrenador/cross/inicio";
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario user = (Usuario) session.getAttribute("usuario");
        Entrenador entrenador = entrenadorService.buscarEntrenador(user.getId());
        model.addAttribute("entrenador", entrenador);
        return strTo;
    }

    @GetMapping("/clientes")
    public String doClientes(Model model, HttpSession session) {
        String strTo = "entrenador/cross/clientes";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario user = (Usuario) session.getAttribute("usuario");
        List<Usuario> listClientes = usuarioService.listarClientes(user.getId());
        model.addAttribute("listClientes", listClientes);
        return strTo;
    }

    /*@GetMapping("/clientes/{id}/rutinas")
    public String doCrearRutina(Model model, HttpSession session, @PathVariable Integer id) {
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        return "redirect:/entrenadorCross/clientes/"+ id + "/rutinas";
    }*/

    @GetMapping("/clientes/{id}/rutinas")
    public String doRutinas(Model model, HttpSession session, @PathVariable Integer id) {
        //String strTo = "redirect:/entrenadorCross/clientes/"+id+"/rutinas/crearRutina";
        String strTo = "entrenador/cross/rutinasCliente";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario user = (Usuario) session.getAttribute("usuario");

        Entrenador entrenador = entrenadorService.buscarEntrenador(user.getId());
        model.addAttribute("entrenador", entrenador);

        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);

        List<RutinaUsuario> lista = rutinaUsuarioService.listarRutinasCliente(id);
        List<RutinaEntity> listaRutinas=new ArrayList<RutinaEntity>();
        RutinaEntity rutinaEntity;
        for(RutinaUsuario rutina : lista){
            rutinaEntity= rutinaRepository.findById(rutina.getRutina().getId()).orElse(null);//no se si este null dara problemas
            listaRutinas.add(rutinaEntity);
        }
        model.addAttribute("listaRutinas", rutinaService.listarRutinasEntidades(listaRutinas));

        Rutina rutina = new Rutina();
        rutina.setFechacreacion(Instant.now());
        rutina.setEntrenador(entrenador);
        rutinaService.guardar(rutina);


        RutinaUsuario rutinaUsuario = new RutinaUsuario();
        rutinaUsuario.setRutina(rutina);
        rutinaUsuario.setUsuario(cliente);
        rutinaUsuarioService.guardar(rutinaUsuario);

        model.addAttribute("rutina", rutina);
        model.addAttribute("rutinaId", rutina.getId());
        return strTo;
    }

    @GetMapping("/clientes/{id}/rutinas/crear")
    public String doCrearRutinas(Model model, HttpSession session, @PathVariable Integer id, @RequestParam Integer rutinaId) {
        String strTo = "entrenador/cross/creacionRutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        model.addAttribute("rutinaId", rutinaId);
        List<RutinaSesion> lista = rutinaSesionService.buscarRutinaSesion(rutinaId);
        model.addAttribute("listaRutinas", lista);
        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);

        return strTo;
    }

    /*@GetMapping("/clientes/{id}/rutinas/borrar")
    public String doBorrarRutinas(Model model, HttpSession session, @PathVariable Integer id, @RequestParam Integer rutinaId) {
        String strTo = "entrenador/cross/creacionRutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        model.addAttribute("rutinaId", rutinaId);
        List<RutinaSesion> lista = rutinaSesionService.buscarRutinaSesion(rutinaId);
        model.addAttribute("listaRutinas", lista);
        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);

        return strTo;
    }*/

    @GetMapping("/clientes/{id}/rutinas/crear/{sesionId}")
    public String doCrearRutinasConSesion(Model model, HttpSession session, @PathVariable Integer id, @RequestParam Integer rutinaId,
                                 @PathVariable Integer sesionId) {
        if(sesionId==null){
            sesionId = 0;
        }
        String strTo = "entrenador/cross/creacionRutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        model.addAttribute("rutinaId", rutinaId);
        List<RutinaSesion> lista = rutinaSesionService.buscarRutinaSesion(rutinaId);
        model.addAttribute("listaRutinas", lista);
        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);

        return strTo;
    }

    @GetMapping("/{id}/crearRutinaSesion/{dia}")
    public String doCrearRutinaSesion(Model model, HttpSession session, @PathVariable Integer id, @PathVariable short dia,
                                      @RequestParam Integer rutinaId) {
        //String strTo = "entrenador/cross/sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);

        model.addAttribute("rutina", rutinaId);

        Sesion sesion = new Sesion();
        sesion.setCrosstraining(true);
        sesionService.guardar(sesion);
        model.addAttribute("sesion", sesion);
        RutinaSesion rutinaSesion = new RutinaSesion();
        rutinaSesion.setRutina(rutinaService.buscarRutina(rutinaId));
        rutinaSesion.setDiadesemana(dia);
        rutinaSesion.setSesion(sesion);
        rutinaSesionService.guardar(rutinaSesion);

        /*SesionEjercicio sesionEjercicio = new SesionEjercicio();
        sesionEjercicio.setSesion(sesion);*/
        /*List<SesionEjercicio> listSesionEjs = sesionEjercicioService.buscarSesionEjercicioPorIdSesion(sesion.getId());
        model.addAttribute("listSesionEjs", listSesionEjs);*/
        return "redirect:/entrenadorCross/"+ id + "/crearRutinaSesion/" + dia + "/listarSesiones?rutinaId=" + rutinaId + "&sesionId=" + sesion.getId();
    }

    @GetMapping("/{id}/crearRutinaSesion/{dia}/listarSesiones")
    public String listarSesiones(Model model, HttpSession session, @PathVariable Integer id, @PathVariable short dia,
                                 @RequestParam Integer rutinaId, @RequestParam("sesionId") Integer sesionId){//?rutinaId=\" + rutinaId + \"&sesionId=\" + sesionId;\n")
        String strTo = "entrenador/cross/sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        model.addAttribute("dia",dia);
        model.addAttribute("sesionId", sesionId);
        model.addAttribute("rutinaId", rutinaId);
        Usuario cliente = usuarioService.buscarUsuario(id);
        model.addAttribute("cliente", cliente);
        Sesion sesion = sesionService.buscarSesion(sesionId);
        List<SesionEjercicio> listSesionEjs = sesionEjercicioService.buscarSesionEjercicioPorIdSesion(sesion.getId());
        model.addAttribute("listSesionEjs", listSesionEjs);
        return strTo;
    }

    @GetMapping("/{id}/crearRutinaSesion/{dia}/crearEjercicio")
    public String crearSesionEjercicio(Model model, HttpSession session, @PathVariable Integer id, @PathVariable short dia,
                                       @RequestParam Integer rutinaId, @RequestParam("sesionId") Integer sesionId){
        String strTo = "entrenador/cross/sesionEjercicio";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        model.addAttribute("dia", dia);
        model.addAttribute("sesionId", sesionId);
        model.addAttribute("rutinaId", rutinaId);
        Usuario cliente = usuarioService.buscarUsuario(id);
        SesionEjercicio sesionEjercicio= new SesionEjercicio();
        //sesionEjercicio.setSesion(sesion);
        model.addAttribute("sesionEjercicio", sesionEjercicio);
        List<Ejercicio> ejercicioList = this.ejercicioService.listarEjercicios();
        model.addAttribute("ejercicioList", ejercicioList);
        /*model.addAttribute("rutina", rutinaId);
        model.addAttribute("sesion", sesion);
        model.addAttribute("clienteId", id);*/
        model.addAttribute("sesionId", sesionId);
        return strTo;
    }

    @PostMapping("/guardarEjercicio")
    public String guardarEjericio(Model model, HttpSession session,
                                  @RequestParam("id") Integer cliente,
                                  @RequestParam("dia") Short dia,
                                  @ModelAttribute("sesionEjercicio") SesionEjercicio sesionEjercicio,
                                  @RequestParam("rutinaId") Integer rutinaId,
                                  @RequestParam("sesionId") Integer sesionId) {

        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Sesion sesion = sesionService.buscarSesion(sesionId);
        sesionEjercicio.setSesion(sesion);
        sesionEjercicioService.guardar(sesionEjercicio);
        String strTo = "redirect:/entrenadorCross/" + cliente + "/crearRutinaSesion/" + dia + "/listarSesiones?rutinaId=" + rutinaId + "&sesionId=" + sesion.getId();

        return strTo;
    }


    @GetMapping("/rutinas")
    public String doRutinas(Model model, HttpSession session) {
        String strTo = "entrenador/cross/rutinas";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario user = (Usuario) session.getAttribute("usuario");

        Entrenador entrenador = entrenadorService.buscarEntrenador(user.getId());
        List<Rutina> lista = rutinaService.listarRutinas(entrenador.getId());
        return strTo;
    }
}

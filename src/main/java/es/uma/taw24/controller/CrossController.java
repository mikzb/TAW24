package es.uma.taw24.controller;

import es.uma.taw24.DTO.*;
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
    /*@Autowired
    protected RutinaSesionRepository rutinaSesionRepository;
    @Autowired
    protected SesionRepository sesionRepository;
    @Autowired
    protected SesionEjercicioRepository sesionEjercicioRepository;
    @Autowired
    protected EjercicioRepository ejercicioRepository;
    @Autowired
    protected RutinaSesionRepository rsRepository;*/

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

    @GetMapping("/clientes/{id}/rutinas")
    public String doRutinas(Model model, HttpSession session, @PathVariable Integer id) {
        String strTo = "redirect:/entrenadorCross/clientes/"+id+"/rutinas/crearRutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        Usuario user = (Usuario) session.getAttribute("usuario");

        Entrenador entrenador = entrenadorService.buscarEntrenador(user.getId());
        model.addAttribute("entrenador", entrenador);

        Usuario cliente = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("cliente", cliente);

        List<RutinaUsuario> lista = rutinaUsuarioService.listarRutinasCliente(id);
        List<RutinaEntity> listaRutinas=new ArrayList<RutinaEntity>();
        for(RutinaUsuario rutina : lista){
            listaRutinas.add(rutina.getIdrutina());
        }
        model.addAttribute("listaRutinas", rutinaService.listarRutinasEntidades(listaRutinas));


        return strTo;
    }

    @GetMapping("/clientes/{id}/rutinas/crearRutina")
    public String doCrearRutina(Model model, HttpSession session, @PathVariable Integer id, @ModelAttribute Entrenador entrenador){
        String strTo = "entrenador/cross/rutinasCliente";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        Rutina rutina = new Rutina();
        rutina.setFechacreacion(Instant.now());
        rutina.setIdentrenador(entrenador);
        rutinaService.guardar(rutina);
        model.addAttribute("rutina", rutina);
        return strTo;
    }

    @GetMapping("/clientes/{id}/rutinas/crear")
    public String doCrearRutinas(Model model, HttpSession session, @PathVariable Integer id, @ModelAttribute Rutina rutina) {
        String strTo = "entrenador/cross/creacionRutina";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        List<RutinaSesion> lista = rutinaSesionService.buscarRutinaSesion(rutina.getId());
        model.addAttribute("listaRutinas", lista);
        Usuario cliente = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("cliente", cliente);

        return strTo;
    }

    @GetMapping("{id}/crearRutinaSesion/{dia}")
    public String doCrearRutinaSesion(Model model, HttpSession session, @PathVariable Integer id, @PathVariable short dia,
                                      @ModelAttribute Rutina rutina) {
        String strTo = "entrenador/cross/sesion";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }

        Sesion sesion = new Sesion();
        sesion.setCrosstraining(true);

        RutinaSesion rutinaSesion = new RutinaSesion();
        rutinaSesion.setRutina(rutinaService.buscarRutina(rutina.getId()));
        rutinaSesion.setDiadesemana(dia);
        rutinaSesion.setSesion(sesion);

        SesionEjercicio sesionEjercicio = new SesionEjercicio();
        sesionEjercicio.setSesion(sesion);

        model.addAttribute("sesionEjercicio", sesionEjercicio);
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

        return strTo;
    }
}

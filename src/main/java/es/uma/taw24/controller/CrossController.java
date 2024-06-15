package es.uma.taw24.controller;

import es.uma.taw24.DTO.*;
import es.uma.taw24.entity.*;
import es.uma.taw24.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String doRutinas(Model model, HttpSession session, @PathVariable int id) {
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

    @GetMapping("/clientes/{id}/rutinas/crear")
    public String doCrearRutinas(Model model, HttpSession session, @PathVariable int id) {
        String strTo = "entrenador/cross/rutinaCross";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        RutinaForm rutinaForm = new RutinaForm();
        model.addAttribute("rutinaForm", rutinaForm);
        Usuario cliente = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("cliente", cliente);
        /*model.addAttribute("rutinaSesion", new RutinaSesion());
        model.addAttribute("sesion", new Sesion());
        model.addAttribute("sesionEjercicio", new SesionEjercicio());
        model.addAttribute("ejercicio", new Ejercicio());*/
        model.addAttribute("listaEj", ejercicioService.listarEjercicios());
        model.addAttribute("rutina", new Rutina());
        return strTo;
    }

    @PostMapping("/guardar")
    public String guardar(Model model, HttpSession session, @ModelAttribute RutinaForm rutinaForm, @ModelAttribute Rutina rutina) {
        String strTo = "entrenador/cross/rutinaCross";
        if(!estaAutenticado(session)){
            return redirectToLogin();
        }
        if (!esEntrenador(session)) {
            return accessDenied();
        }
        RutinaSesion rutinaSesion = rutinaForm.getRutinaSesion();
        /*RutinaEntity re = rutinaSesion.getIdrutina();
        SesionEntity se = rutinaSesion.getIdsesion();
        RutinaSesionIdEntity rsId = new RutinaSesionIdEntity();
        rsId.setIdsesion(se.getId());
        rsId.setIdrutina(rutina.getId());
        rutinaSesion.setId(rsId);*/
        Sesion sesion = rutinaForm.getSesion();
        sesion.setCrosstraining(true);
        rutinaSesion.setIdsesion(sesionService.buscarSesion(sesion.getId()));
        rutinaSesion.setIdrutina(rutinaService.buscarRutinaPorId(rutina.getId()).toDTO());
        SesionEjercicio sesionEjercicio = rutinaForm.getSesionEjercicio();
        sesionEjercicio.setSesion(sesionService.buscarSesion(sesion.getId()));
        Ejercicio ejercicio = rutinaForm.getEjercicio();//este ejercicio solo tiene id realmente
        sesionEjercicio.setEjercicio(ejercicioService.buscarEjercicioPorId(ejercicio.getId()).toDTO());
        sesionEjercicioService.guardarSesionEjercicio(sesionEjercicio);
        sesionService.guardar(sesion);
        //rutinaSesionService.guardar(rutinaSesion);
        return strTo;
        /*RutinaSesion rutinaSesion = new RutinaSesion();
        rutinaSesion.setId(rutinaForm.getRutinaSesionId());
        Sesion sesion = rutinaForm.getSesion();
        sesion.setCrosstraining(true);
        rutinaSesion.setIdsesion(sesionService.buscarSesionPorId(sesion.getId()));
        rutinaSesion.setIdrutina(rutinaService.buscarRutinaPorId(rutina.getId()));
        SesionEjercicio sesionEjercicio = rutinaForm.getSesionEjercicio();
        sesionEjercicio.setIdsesion(sesionService.buscarSesionPorId(sesion.getId()));
        Ejercicio ejercicio = rutinaForm.getEjercicio();//este ejercicio solo tiene id realmente
        sesionEjercicio.setIdejercicio(ejercicioService.buscarEjercicioPorId(ejercicio.getId()));
        sesionEjercicioService.guardar(sesionEjercicio);
        sesionService.guardar(sesion);
        rutinaSesionService.guardar(rutinaSesion);
        return strTo;*/
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

    /*
    @PostMapping("/rutinaCross/addSesion")
    public String addSesion(Model model, RutinaSesionEntity rutinaSesion, SesionEntity sesion,
                            SesionEjercicioEntity sesionEjercicio) {

        RutinaSesionEntity rutinaSesion2;
        if( !rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId()).equals(null) ){
            rutinaSesion2 = rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId());
        }else{
            rutinaSesion2 = new RutinaSesionEntity();
        }
        rutinaSesion2.setIdrutina(rutinaSesion.getIdrutina());
        rutinaSesion2.setIdsesion(rutinaSesion.getIdsesion());
        rutinaSesion2.setDiadesemana(rutinaSesion.getDiadesemana());

        SesionEntity sesion2 = this.sesionRepository.findById(sesion.getId()).orElse(new SesionEntity());
        sesion2.setCrosstraining(true);

        SesionEjercicioEntity sesionEjercicio2;
        if( sesionEjercicioRepository.findBySesionEjercicioId(sesionEjercicio.getId()) != null ){
            sesionEjercicio2 = sesionEjercicioRepository.findBySesionEjercicioId(sesionEjercicio.getId());
        }else{
            sesionEjercicio2 = new SesionEjercicioEntity();
        }
        sesionEjercicio2.setIdsesion(sesionEjercicio.getIdsesion());
        sesionEjercicio2.setCompletado(sesionEjercicio.getCompletado());
        sesionEjercicio2.setDistancia(sesionEjercicio.getDistancia());
        sesionEjercicio2.setDuracion(sesionEjercicio.getDuracion());
        sesionEjercicio2.setIdejercicio(sesionEjercicio.getIdejercicio());
        sesionEjercicio2.setPeso(sesionEjercicio.getPeso());
        sesionEjercicio2.setOrden(sesionEjercicio.getOrden());
        sesionEjercicio2.setRepeticiones(sesionEjercicio.getRepeticiones());
        sesionEjercicio2.setVelocidad(sesionEjercicio.getVelocidad());
        return "rutinaCross";
    }*/



}

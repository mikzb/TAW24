/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.controller;

import es.uma.taw24.DTO.*;
import es.uma.taw24.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dietista")
public class DietistaController extends BaseController {

    @Autowired
    private DietaService dietaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComidaService comidaService;

    @GetMapping("/")
    public String doInicio() {
        return "./Dietista/inicioDietista";
    }

    @GetMapping("/dietas")
    public String doDietas(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Dieta> dietas = this.dietaService.listarDietasDietista(usuario.getId());

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }

    @GetMapping("/crearDieta")
    public String doCrearDieta(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dieta = new Dieta();
        dieta.setDias(new ArrayList<>());
        for (int i = 0; i < 7; i++) {
            Dia dia = new Dia();
            Menu menu = new Menu();
            menu.setComidas(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                menu.getComidas().add(new Comida());
            }
            dia.setMenu(menu);
            dieta.getDias().add(dia);
        }
        model.addAttribute("dieta", dieta);

        List<Comida> comidas = this.comidaService.listarComidas();
        model.addAttribute("comidasDisponibles", comidas);

        return "./Dietista/crearDieta";
    }

    @GetMapping("/editarDieta")
    public String doEditarDieta(@RequestParam("id") Integer dietaId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dietaActual = this.dietaService.buscarPorDietaId(dietaId);
        model.addAttribute("dietaActual", dietaActual);

        Dieta dietaNueva = new Dieta();
        dietaNueva.setDias(new ArrayList<>());
        for (int i = 0; i < 7; i++) {
            Dia dia = new Dia();
            Menu menu = new Menu();
            menu.setComidas(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                menu.getComidas().add(new Comida());
            }
            dia.setMenu(menu);
            dietaNueva.getDias().add(dia);
        }
        model.addAttribute("dietaNueva", dietaNueva);

        List<Comida> comidas = this.comidaService.listarComidas();
        model.addAttribute("comidasDisponibles", comidas);

        return "./Dietista/editarDieta";
    }

    //TODO: Could not set value of type [java.lang.Integer]: 'es.uma.taw24.entity.DietaDiaIdEntity.iddia' (setter)
    @PostMapping("/guardarCreacionDieta")
    public String doGuardarCreacionDieta(@ModelAttribute("dieta") Dieta dieta, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Integer dietistaId = ((Usuario) session.getAttribute("usuario")).getId();

        this.dietaService.guardarDietaCreada(dieta, dietistaId);

        return "redirect:/dietas";
    }

    //TODO: actualizarDescripcionDieta, actualizarComida
    @PostMapping("/guardarEdicionDieta")
    public String doGuardarEdicionDieta(@RequestParam("dietaId") Integer dietaId, @ModelAttribute("dieta") Dieta dietaNueva, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dietaActual = this.dietaService.buscarPorDietaId(dietaId);

        if (!dietaActual.getDescripcion().equals(dietaNueva.getDescripcion())) {
            this.dietaService.actualizarDescripcionDieta(dietaId, dietaNueva.getDescripcion());
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                Comida comidaActual = dietaActual.getDias().get(i).getMenu().getComidas().get(j);
                Comida comidaNueva = dietaNueva.getDias().get(i).getMenu().getComidas().get(j);

                if (comidaActual.getId() != comidaNueva.getId() ) {
                    this.dietaService.actualizarComida(comidaActual.getId(), comidaNueva.getId(), i, j);
                }
            }
        }

        return "redirect:/dietas";
    }

    @GetMapping("/eliminarDieta")
    public String doEliminarDieta(@RequestParam("id") Integer dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        this.dietaService.borrarDieta(dietaId);

        return "redirect:/dietista/dietas";
    }

    @GetMapping("/clientesDietista")
    public String doClientes(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Integer dietistaId = ((Usuario) session.getAttribute("usuario")).getId();
        List<Usuario> clientes = this.usuarioService.listarClientesPorDietistaId(dietistaId);
        model.addAttribute("clientes", clientes);

        return "./Dietista/clientesDietista";
    }

    //TODO: LA QUERY DEVUELVE 10 COMIDAS, DEBERÍA DEVOLVER 35
    @GetMapping("/verDietaDietista")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dieta = this.dietaService.buscarComidasPorDietaId(dietaId);
        model.addAttribute("dieta", dieta);

        return "./Dietista/verDietaDietista";
    }

    //TODO: LA QUERY DEVUELVE 10 COMIDAS, DEBERÍA DEVOLVER 35
    @GetMapping("/verProgresoDieta")
    public String doVerProgresoDieta(@RequestParam("id") Integer id, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dieta = this.dietaService.buscarComidasPorDietaId(id);
        model.addAttribute("dieta", dieta);

        return "./Dietista/verProgresoDieta";
    }

    @GetMapping("/cambiarDietaDietista")
    public String doCambiarDieta(@RequestParam("id") Integer usuarioId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        model.addAttribute("usuarioId", usuarioId);

        Integer dietistaId = ((Usuario) session.getAttribute("usuario")).getId();

        List<Dieta> dietas = this.dietaService.listarDietasDietista(dietistaId);
        Dieta dietaActual = this.dietaService.buscarDietaPorUsuarioId(usuarioId);
        dietas.remove(dietaActual);
        model.addAttribute("dietaActual", dietaActual);

        model.addAttribute("dietas", dietas);

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        return "./Dietista/cambiarDietaDietista";
    }

    @PostMapping("/guardarCambioDieta")
    public String doGuardarCambioDieta(@RequestParam("usuarioId") Integer usuarioId, @ModelAttribute("dieta") Dieta dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        this.dietaService.actualizarUsuarioDieta(usuarioId, dietaId.getId());

        return "redirect:/dietista/clientesDietista";
    }

    @PostMapping("/asignar")
    public String asignarDietista(UsuarioDietistaForm usuarioDietistaForm) {
        usuarioService.asignarDietista(usuarioDietistaForm);
        return "redirect:/usuario/listado";
    }

    @PostMapping("/desasignar")
    public String desasignarDietista(Usuario usuario) {
        usuarioService.desasignarDietista(usuario);
        return "redirect:/usuario/listado";
    }
}

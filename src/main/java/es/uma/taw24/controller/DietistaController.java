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

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }

    @PostMapping("/filtrarDietas")
    public String doFiltrarDietas(@ModelAttribute("dieta") Dieta dietaD, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Dieta> dietas = this.dietaService.listarDietasDietistaPorDescripcion(usuario.getId(), dietaD.getDescripcion());

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        model.addAttribute("dietas", dietas);

        return "./Dietista/dietas";
    }

    @GetMapping("/crearDieta")
    public String doCrearDieta(@RequestParam("id") Integer dietaId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        List<Comida> comidasDisponibles = this.comidaService.listarComidas();
        Dieta dieta;
        if (dietaId != 0) {
            dieta = this.dietaService.cargarDietaPorDietaId(dietaId);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 5; j++) {
                    List<Comida> comidas = new ArrayList<>(comidasDisponibles);
                    Comida comida = dieta.getDias().get(i).getMenu().getComidas().get(j);
                    comidas.remove(comida);
                    comidas.add(0, comida);
                    model.addAttribute("comidas" + (i * 5 + j + 1), comidas);
                }
            }
        } else {
            dieta = new Dieta();
            dieta.setDias(new ArrayList<>());
            for (int i = 0; i < 7; i++) {
                Dia dia = new Dia();
                Menu menu = new Menu();
                menu.setComidas(new ArrayList<>());
                for (int j = 0; j < 5; j++) {
                    menu.getComidas().add(new Comida());
                    model.addAttribute("comidas" + (i * 5 + j + 1), comidasDisponibles);
                }
                dia.setMenu(menu);
                dieta.getDias().add(dia);
            }
        }

        model.addAttribute("dietaActual", dieta);
        model.addAttribute("dietaNueva", new Dieta());

        return "./Dietista/crearDieta";
    }

    @GetMapping("/importarDieta")
    public String doImportarDieta(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Integer dietistaId = ((Usuario) session.getAttribute("usuario")).getId();

        List<Dieta> dietas = this.dietaService.listarDietasDietista(dietistaId);
        model.addAttribute("dietas", dietas);

        Dieta dieta = new Dieta();
        model.addAttribute("dieta", dieta);

        return "./Dietista/elegirDieta";
    }

    @GetMapping("/guardarImportacion")
    public String doGuardarImportacion(@ModelAttribute("dieta") Dieta dieta, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Integer dietaId = dieta.getId();

        return "redirect:/dietista/crearDieta?id=" + dietaId;
    }

    //TODO: si una comida se repite en un dia salta error
    @GetMapping("/editarDieta")
    public String doEditarDieta(@RequestParam("id") Integer dietaId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dietaActual = this.dietaService.cargarDietaPorDietaId(dietaId);
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

        List<Comida> comidasDisponibles = this.comidaService.listarComidas();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                List<Comida> comidas = new ArrayList<>(comidasDisponibles);
                Comida comida = dietaActual.getDias().get(i).getMenu().getComidas().get(j);
                comidas.remove(comida);
                comidas.add(0, comida);
                model.addAttribute("comidas" + (i * 5 + j + 1), comidas);
            }
        }

        return "./Dietista/editarDieta";
    }

    //TODO: si una comida se repite en un dia salta error (por ello la doble comida vacía)
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

        return "redirect:/dietista/dietas";
    }

    @PostMapping("/guardarEdicionDieta")
    public String doGuardarEdicionDieta(@RequestParam("dietaId") Integer dietaId, @ModelAttribute("dieta") Dieta dietaNueva, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dietaActual = this.dietaService.cargarDietaPorDietaId(dietaId);

        if (!dietaActual.getDescripcion().equals(dietaNueva.getDescripcion())) {
            this.dietaService.actualizarDescripcionDieta(dietaId, dietaNueva.getDescripcion());
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                Integer comidaActualId = dietaActual.getDias().get(i).getMenu().getComidas().get(j).getId();
                Integer comidaNuevaId = dietaNueva.getDias().get(i).getMenu().getComidas().get(j).getId();

                if (comidaActualId != comidaNuevaId) {
                    Integer menuId = dietaActual.getDias().get(i).getMenu().getId();
                    this.dietaService.actualizarComida(menuId, comidaActualId, comidaNuevaId);
                }
            }
        }

        return "redirect:/dietista/verDietaDietista?id=" + dietaId;
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

    @GetMapping("/verDietaDietista")
    public String doVerDietaCreada(Model model, @RequestParam("id") Integer dietaId, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Dieta dieta = this.dietaService.cargarDietaPorDietaId(dietaId);
        model.addAttribute("dieta", dieta);

        return "./Dietista/verDietaDietista";
    }

    @GetMapping("/verProgresoDieta")
    public String doVerProgresoDieta(@RequestParam("id") Integer clienteId, Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esDietista(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Integer dietaId = this.dietaService.buscarDietaPorUsuarioId(clienteId).getId();

        Dieta dieta = this.dietaService.cargarDietaPorDietaId(dietaId);
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
        model.addAttribute("dietaActual", dietaActual);

        dietas.remove(dietaActual);
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

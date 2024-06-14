/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/cliente")
public class ClienteController extends BaseController{

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

    @GetMapping("/entrenamientoCliente")
    public String doEntrenamientoCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }
        return "entrenamientoCliente";
    }

    @GetMapping("/dietaCliente")
    public String doDietaCliente(Model model, HttpSession session) {
        if (!estaAutenticado(session)) {
            return redirectToLogin();
        }
        if (!esCliente(session) && !esAdmin(session)) {
            return accessDenied();
        }

        Long clienteId = (Long) session.getAttribute("usuarioId");
        List<ComidaEntity> comidas = comidaRepository.findComidasByClienteId(clienteId);
        model.addAttribute("comidas", comidas);

        return "dietaCliente";
    }

}

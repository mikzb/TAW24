/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.UsuarioEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDate;

import java.time.ZoneOffset;
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
    // TODO : que la fecha sea la actual, ahora no esta pq no hay dietas para hoy xd
        Usuario cliente = (Usuario) session.getAttribute("usuario");
        Integer clienteId = cliente.getId();
        model.addAttribute("usuario", cliente);
        Instant fecha = LocalDate.of(2024, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);
        List<ComidaEntity> comidas = comidaRepository.findComidasByClienteId(Long.valueOf(clienteId),fecha);
        model.addAttribute("comidas", comidas);

        return "dietaCliente";
    }

}

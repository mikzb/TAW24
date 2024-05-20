/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import es.uma.taw24.entity.Dieta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClienteController {

    private static int clienteID = 1;

    @GetMapping("/inicioCliente")
    public String doInicio() {
        return "inicioCliente";
    }

    @PostMapping("/entrenamientoCliente")
    public String doEntrenamientoCliente(Model model) {
        return "entrenamientoCliente";
    }

    @PostMapping("/dietaCliente")
    public String doDietaCliente(Model model) {
        return "dietaCliente";
    }

}

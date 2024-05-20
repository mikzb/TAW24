/*
@author Mikolaj Zabski
 */

package es.uma.taw24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

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
        String[][] dieta = {
                {"Comida", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"},
                {"Desayuno", "Jamón", "Sardina", "Ajo y Pimiento", "Pan Integral", "Sémola", "Tomate", "Arroz"},
                {"Media Mañana", "Berenjena", "Cacahuete", "Nueces", "Avellana", "Cacao", "Aguacate", "Atún"},
                {"Comida", "Pistacho", "Paella", "Bellota", "Huevo", "Garbanzo", "Tortilla", "Macarrones"},
                {"Merienda", "Ternera", "Mandarina", " ", "Fresa", " ", "Platano", "Melón"},
                {"Cena", "Yogurt", " ", " ", "Naranja", "Ensalada", "Queso", "Salchichón"}
        };
        model.addAttribute("dieta", dieta);
        return "dietaCliente";
    }

}

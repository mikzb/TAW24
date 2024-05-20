/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class DietistaController {
    @GetMapping("/")
    public String doInicio() {
        return "inicioDietista";
    }

    @PostMapping("/dietaDietista")
    public String doDieta(Model model) {
        String[][] dieta = {
                {"Comida", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"},
                {"Desayuno", "Jamón", "Sardina", "Ajo y Pimiento", "Pan Integral", "Sémola", "Tomate", "Arroz"},
                {"Media Mañana", "Berenjena", "Cacahuete", "Nueces", "Avellana", "Cacao", "Aguacate", "Atún"},
                {"Comida", "Pistacho", "Paella", "Bellota", "Huevo", "Garbanzo", "Tortilla", "Macarrones"},
                {"Merienda", "Ternera", "Mandarina", " ", "Fresa", " ", "Platano", "Melón"},
                {"Cena", "Yogurt", " ", " ", "Naranja", "Ensalada", "Queso", "Salchichón"}
        };
        model.addAttribute("dieta", dieta);

        return "dietaDietista";
    }

    @PostMapping("/clientesDietista")
    public String doClientes(Model model) {
        return "clientesDietista";
    }

    @GetMapping("/guardarDieta")
    public String doGuardarDieta(Model model) {
        return "redirect:/";
    }

    @GetMapping("/importarDieta")
    public String doImportarDieta(Model model) {
        return "redirect:/";
    }
}

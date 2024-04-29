package es.uma.taw24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class TawController {
    @GetMapping("/")
    public String doInicio() {
        return "inicio";
    }

    @PostMapping("/dietaDietista")
    public String doDieta(Model model) {
        String[][] palabras = {
                {"Comida", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"},
                {"Desayuno", "Jamón", "Sardina", "Ajo y Pimiento", "Pan Integral", "Sémola", "Tomate", "Arroz"},
                {"Media Mañana", "Berenjena", "Cacahuete", "Nueces", "Avellana", "Cacao", "Aguacate", "Atún"},
                {"Comida", "Pistacho", "Paella", "Bellota", "Huevo", "Garbanzo", "Tortilla", "Macarrones"},
                {"Merienda", "Ternera", "Mandarina", " ", "Fresa", " ", "Platano", "Melón"},
                {"Cena", "Yogurt", " ", " ", "Naranja", "Ensalada", "Queso", "Salchichón"}
        };
        model.addAttribute("palabras", palabras);

        return "dietaDietista";
    }

    @PostMapping("/clientesDietista")
    public String doClientes(Model model) {
        return "clientesDietista";
    }
}

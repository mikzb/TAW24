/**
 * @author
 * Álvaro Acedo Espejo: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class RutinaSesion {
    private Rutina rutina;
    private Sesion sesion;
    private Short diadesemana;

    public String getNombreDia() {
        return switch (diadesemana) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "";
        };
    }
}

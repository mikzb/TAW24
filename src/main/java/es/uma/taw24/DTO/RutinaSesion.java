/**
 * @author
 * Álvaro Acedo Espejo: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class RutinaSesion {
    private Rutina idrutina;
    private Sesion idsesion;
    private String diadesemana;
}

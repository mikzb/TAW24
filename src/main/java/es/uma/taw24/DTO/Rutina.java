/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class Rutina {
    private Integer id;
    private Entrenador entrenador;
    private Instant fechacreacion;
}

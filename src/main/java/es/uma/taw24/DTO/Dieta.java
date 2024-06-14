/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class Dieta {
    private Integer id;
    private Instant fechaCreacion;
    private String descripcion;
    private List<Dia> dias;
}

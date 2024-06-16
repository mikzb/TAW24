package es.uma.taw24.DTO;

/**
 * @author Ignacy Borzestowski: 100%
 */

import lombok.Data;

import java.util.List;

@Data
public class GrupoMuscular {
    private Integer id;
    private String nombre;
    private List<Ejercicio> ejercicios;
}

package es.uma.taw24.DTO;

/**
 * @author Ignacy Borzestowski: 100%
 */


import lombok.Data;

@Data
public class Ejercicio {
    private Integer id;
    private Tipo tipo;
    private String nombre;
    private String url;
}

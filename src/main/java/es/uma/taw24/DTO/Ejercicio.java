package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class Ejercicio {
    private int id;
    private Tipo tipo;
    private String nombre;
    private String url;
}
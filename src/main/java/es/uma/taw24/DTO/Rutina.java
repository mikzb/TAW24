package es.uma.taw24.DTO;

import es.uma.taw24.entity.EntrenadorEntity;
import lombok.Data;

import java.time.Instant;

@Data
public class Rutina {
    private Integer id;
    private Entrenador identrenador;
    private Instant fechacreacion;
}

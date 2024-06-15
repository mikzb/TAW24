package es.uma.taw24.DTO;

import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaSesionIdEntity;
import es.uma.taw24.entity.SesionEntity;
import lombok.Data;

@Data
public class RutinaSesion {
    private Rutina idrutina;
    private Sesion idsesion;
    private String diadesemana;
}

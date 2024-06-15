package es.uma.taw24.DTO;

import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioIdEntity;
import es.uma.taw24.entity.SesionEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SesionEjercicio {
    private SesionEntity idsesion;
    private EjercicioEntity idejercicio;
    private Integer repeticiones;
    private Integer duracion;
    private Short peso;
    private Boolean completado = false;//??
    private Integer orden;
    private Integer velocidad;
    private Integer distancia;
}

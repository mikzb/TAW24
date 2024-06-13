package es.uma.taw24.DTO;


import es.uma.taw24.entity.UsuarioEntity;
import lombok.Data;

@Data
public class Entrenador {
    private boolean crosstraining;
    private UsuarioEntity usuario;
}

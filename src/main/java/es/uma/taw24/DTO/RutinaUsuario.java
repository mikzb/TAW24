package es.uma.taw24.DTO;

import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaUsuarioIdEntity;
import es.uma.taw24.entity.UsuarioEntity;
import lombok.Data;

@Data
public class RutinaUsuario {
    private RutinaUsuarioIdEntity id;
    private RutinaEntity idrutina;
    private UsuarioEntity idusuario;
}
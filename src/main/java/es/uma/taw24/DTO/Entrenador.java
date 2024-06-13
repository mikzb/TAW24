/**
 * @author Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.DTO;


import es.uma.taw24.entity.UsuarioEntity;
import lombok.Data;

@Data
public class Entrenador {
    private int id;
    private boolean crosstraining;
    private UsuarioEntity usuario;
}

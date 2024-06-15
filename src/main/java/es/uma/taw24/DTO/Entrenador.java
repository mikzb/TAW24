/**
 * @author Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.DTO;


import lombok.Data;

@Data
public class Entrenador {
    private Integer id;
    private boolean crosstraining;
    private Usuario usuario;

    public String getNombreCompleto() {
        return usuario.getNombre() + " " + usuario.getApellidos();
    }
}

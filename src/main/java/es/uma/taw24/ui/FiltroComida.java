package es.uma.taw24.ui;

/**
 * @author Ignacy Borzestowski: 100%
 */

import lombok.Data;

@Data
public class FiltroComida {
    private String descripcion;

    public boolean estaVacio () {
        return descripcion.isEmpty();
    }
}

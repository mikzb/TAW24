package es.uma.taw24.ui;

/**
 * @author Ignacy Borzestowski: 100%
 */

import lombok.Data;

@Data
public class FiltroTipo {
    private String nombre;

    public boolean estaVacio () {
        return nombre.isEmpty();
    }
}

package es.uma.taw24.ui;

/**
 * @author Ignacy Borzestowski: 100%
 */

import lombok.Data;

@Data
public class FiltroEjercicio {
    private String nombre;
    private String tipo;
    private String grupoMuscular;

    public boolean estaVacio () {
        return nombre.isEmpty() && tipo.isEmpty() && grupoMuscular.isEmpty();
    }
}

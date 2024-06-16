/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    private List<Comida> comidas;
    private boolean completado;

    public Boolean getCompletado() {
        return completado;
    }

}

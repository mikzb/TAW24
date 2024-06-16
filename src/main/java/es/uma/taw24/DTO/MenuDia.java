package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class MenuDia {

    private Menu menu;
    private Dia dia;
    private Boolean completado;

    public Boolean getCompletado() {
        return completado;
    }

}

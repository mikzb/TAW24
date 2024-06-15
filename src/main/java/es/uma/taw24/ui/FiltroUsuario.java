package es.uma.taw24.ui;

import lombok.Data;

@Data
public class FiltroUsuario {

    private String email;
    private String nombre;
    private String apellidos;
    private String sexo;
    private Short edad;
    private boolean permisoAdmin;
    private boolean permisoEntrenador;
    private boolean permisoDietista;
    private boolean permisoCliente;

    public boolean estaVacio () {
        return email.isEmpty() && nombre.isEmpty() && apellidos.isEmpty() && sexo.isEmpty() && edad == null && !permisoAdmin && !permisoEntrenador && !permisoDietista && !permisoCliente;
    }
}

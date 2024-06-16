package es.uma.taw24.DTO;

/**
 * @author Ignacy Borzestowski: 100%
 */

import lombok.Data;

@Data
public class Usuario {
    private String email;
    private String password;

    private Integer id;
    private String nombre;
    private String apellidos;
    private String sexo;
    private Short edad;
    private boolean permisoAdmin;
    private boolean permisoEntrenador;
    private boolean permisoDietista;
    private boolean permisoCliente;
    private boolean crosstraining;
    private Usuario dietista;

    public String getNombreCompleto() {
        return this.getNombre() + " " + this.getApellidos();
    }
}
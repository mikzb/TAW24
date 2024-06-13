package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class Usuario {
    private String email;
    private String password;

    private int id;
    private String nombre;
    private String apellidos;
    private String sexo;
    private short edad;
    private boolean permisoAdmin;
    private boolean permisoEntrenador;
    private boolean permisoDietista;
    private boolean permisoCliente;
}


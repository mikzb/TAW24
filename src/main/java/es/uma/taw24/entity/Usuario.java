package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "EMAIL", nullable = false, length = 90)
    private String email;

    @Column(name = "PASSWORDHASH", nullable = false, length = 90)
    private String passwordhash;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @Column(name = "APELLIDOS", nullable = false, length = 90)
    private String apellidos;

    @Column(name = "EDAD", nullable = false)
    private Short edad;

    @Column(name = "PERMISOS_ADC", nullable = false)
    private Boolean permisosAdc = false;

    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Boolean getPermisosAdc() {
        return permisosAdc;
    }

    public void setPermisosAdc(Boolean permisosAdc) {
        this.permisosAdc = permisosAdc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
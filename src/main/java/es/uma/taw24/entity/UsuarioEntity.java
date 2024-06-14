package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable, DTO<Usuario> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;

    @Column(name = "PERMISO_ADMIN", nullable = false)
    private Boolean permisoAdmin = false;

    @Column(name = "PERMISO_ENTRENADOR", nullable = false)
    private Boolean permisoEntrenador = false;

    @Column(name = "PERMISO_DIETISTA", nullable = false)
    private Boolean permisoDietista = false;

    @Column(name = "PERMISO_CLIENTE", nullable = false)
    private Boolean permisoCliente = false;

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioDietaEntity> dietausuarios;

    public Boolean getPermisoCliente() {
        return permisoCliente;
    }

    public void setPermisoCliente(Boolean permisoCliente) {
        this.permisoCliente = permisoCliente;
    }

    public Boolean getPermisoDietista() {
        return permisoDietista;
    }

    public void setPermisoDietista(Boolean permisoDietista) {
        this.permisoDietista = permisoDietista;
    }

    public Boolean getPermisoEntrenador() {
        return permisoEntrenador;
    }

    public void setPermisoEntrenador(Boolean permisoEntrenador) {
        this.permisoEntrenador = permisoEntrenador;
    }

    public Boolean getPermisoAdmin() {
        return permisoAdmin;
    }

    public void setPermisoAdmin(Boolean permisoAdmin) {
        this.permisoAdmin = permisoAdmin;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity)) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(passwordhash, that.passwordhash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }


    public Usuario toDTO () {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setEmail(this.email);
        usuario.setPassword(this.passwordhash);
        usuario.setNombre(this.nombre);
        usuario.setApellidos(this.apellidos);
        usuario.setEdad(this.edad);
        usuario.setSexo(this.sexo);
        usuario.setPermisoAdmin(this.permisoAdmin);
        usuario.setPermisoEntrenador(this.permisoEntrenador);
        usuario.setPermisoDietista(this.permisoDietista);
        usuario.setPermisoCliente(this.permisoCliente);
        return usuario;
    }


}
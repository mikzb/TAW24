package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Usuario", schema = "mydb")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "email", nullable = false, length = 90)
    private String email;
    @Basic
    @Column(name = "passwordHash", nullable = false, length = 90)
    private String passwordHash;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 90)
    private String apellidos;
    @Basic
    @Column(name = "edad", nullable = false)
    private Short edad;
    @Basic
    @Column(name = "permisos_adc", nullable = false)
    private Boolean permisosAdc;
    @Basic
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;
    @OneToMany(mappedBy = "usuarioByIdDietista")
    private Collection<DietaEntity> dietasById;
    @OneToOne(mappedBy = "usuarioByIdUsuario")
    private EntrenadorEntity entrenadorById;
    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<EntrenadorUsuarioEntity> entrenadorUsuariosById;
    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<RutinaUsuarioEntity> rutinaUsuariosById;
    @OneToMany(mappedBy = "usuarioByIdUsuario")
    private Collection<UsuarioDietaEntity> usuarioDietasById;

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(passwordHash, that.passwordHash) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(edad, that.edad) && Objects.equals(permisosAdc, that.permisosAdc) && Objects.equals(sexo, that.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, passwordHash, nombre, apellidos, edad, permisosAdc, sexo);
    }

    public Collection<DietaEntity> getDietasById() {
        return dietasById;
    }

    public void setDietasById(Collection<DietaEntity> dietasById) {
        this.dietasById = dietasById;
    }

    public EntrenadorEntity getEntrenadorById() {
        return entrenadorById;
    }

    public void setEntrenadorById(EntrenadorEntity entrenadorById) {
        this.entrenadorById = entrenadorById;
    }

    public Collection<EntrenadorUsuarioEntity> getEntrenadorUsuariosById() {
        return entrenadorUsuariosById;
    }

    public void setEntrenadorUsuariosById(Collection<EntrenadorUsuarioEntity> entrenadorUsuariosById) {
        this.entrenadorUsuariosById = entrenadorUsuariosById;
    }

    public Collection<RutinaUsuarioEntity> getRutinaUsuariosById() {
        return rutinaUsuariosById;
    }

    public void setRutinaUsuariosById(Collection<RutinaUsuarioEntity> rutinaUsuariosById) {
        this.rutinaUsuariosById = rutinaUsuariosById;
    }

    public Collection<UsuarioDietaEntity> getUsuarioDietasById() {
        return usuarioDietasById;
    }

    public void setUsuarioDietasById(Collection<UsuarioDietaEntity> usuarioDietasById) {
        this.usuarioDietasById = usuarioDietasById;
    }
}

package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Rutina", schema = "mydb")
public class RutinaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "idEntrenador", nullable = false)
    private Integer idEntrenador;
    @Basic
    @Column(name = "fechaCreacion", nullable = false)
    private Timestamp fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "idEntrenador", referencedColumnName = "idUsuario", nullable = false)
    private EntrenadorEntity entrenadorByIdEntrenador;
    @OneToMany(mappedBy = "rutinaByIdRutina")
    private Collection<RutinaSesionEntity> rutinaSesionsById;
    @OneToMany(mappedBy = "rutinaByIdRutina")
    private Collection<RutinaUsuarioEntity> rutinaUsuariosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RutinaEntity that = (RutinaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idEntrenador, that.idEntrenador) && Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEntrenador, fechaCreacion);
    }

    public EntrenadorEntity getEntrenadorByIdEntrenador() {
        return entrenadorByIdEntrenador;
    }

    public void setEntrenadorByIdEntrenador(EntrenadorEntity entrenadorByIdEntrenador) {
        this.entrenadorByIdEntrenador = entrenadorByIdEntrenador;
    }

    public Collection<RutinaSesionEntity> getRutinaSesionsById() {
        return rutinaSesionsById;
    }

    public void setRutinaSesionsById(Collection<RutinaSesionEntity> rutinaSesionsById) {
        this.rutinaSesionsById = rutinaSesionsById;
    }

    public Collection<RutinaUsuarioEntity> getRutinaUsuariosById() {
        return rutinaUsuariosById;
    }

    public void setRutinaUsuariosById(Collection<RutinaUsuarioEntity> rutinaUsuariosById) {
        this.rutinaUsuariosById = rutinaUsuariosById;
    }
}

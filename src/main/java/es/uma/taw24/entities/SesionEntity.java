package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Sesion", schema = "mydb")
public class SesionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Crosstraining", nullable = false)
    private Boolean crosstraining;
    @OneToMany(mappedBy = "sesionByIdSesion")
    private Collection<RutinaSesionEntity> rutinaSesionsById;
    @OneToMany(mappedBy = "sesionByIdSesion")
    private Collection<SesionEjercicioEntity> sesionEjerciciosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCrosstraining() {
        return crosstraining;
    }

    public void setCrosstraining(Boolean crosstraining) {
        this.crosstraining = crosstraining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SesionEntity that = (SesionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(crosstraining, that.crosstraining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, crosstraining);
    }

    public Collection<RutinaSesionEntity> getRutinaSesionsById() {
        return rutinaSesionsById;
    }

    public void setRutinaSesionsById(Collection<RutinaSesionEntity> rutinaSesionsById) {
        this.rutinaSesionsById = rutinaSesionsById;
    }

    public Collection<SesionEjercicioEntity> getSesionEjerciciosById() {
        return sesionEjerciciosById;
    }

    public void setSesionEjerciciosById(Collection<SesionEjercicioEntity> sesionEjerciciosById) {
        this.sesionEjerciciosById = sesionEjerciciosById;
    }
}

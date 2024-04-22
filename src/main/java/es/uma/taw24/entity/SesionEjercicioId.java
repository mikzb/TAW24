package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class SesionEjercicioId implements java.io.Serializable {
    private static final long serialVersionUID = 4177059761140599944L;
    @Column(name = "idSesion", nullable = false)
    private Integer idSesion;

    @Column(name = "idEjercicio", nullable = false)
    private Integer idEjercicio;

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SesionEjercicioId entity = (SesionEjercicioId) o;
        return Objects.equals(this.idSesion, entity.idSesion) &&
                Objects.equals(this.idEjercicio, entity.idEjercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSesion, idEjercicio);
    }

}
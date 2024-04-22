package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class RutinaSesionId implements java.io.Serializable {
    private static final long serialVersionUID = -4173160046266387458L;
    @Column(name = "idRutina", nullable = false)
    private Integer idRutina;

    @Column(name = "idSesion", nullable = false)
    private Integer idSesion;

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RutinaSesionId entity = (RutinaSesionId) o;
        return Objects.equals(this.idSesion, entity.idSesion) &&
                Objects.equals(this.idRutina, entity.idRutina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSesion, idRutina);
    }

}
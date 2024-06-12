package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class SesionEjercicioIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 874203322408008930L;
    @Column(name = "IDSESION", nullable = false)
    private Integer idsesion;

    @Column(name = "IDEJERCICIO", nullable = false)
    private Integer idejercicio;

    public Integer getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Integer idsesion) {
        this.idsesion = idsesion;
    }

    public Integer getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(Integer idejercicio) {
        this.idejercicio = idejercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SesionEjercicioIdEntity entity = (SesionEjercicioIdEntity) o;
        return Objects.equals(this.idejercicio, entity.idejercicio) &&
                Objects.equals(this.idsesion, entity.idsesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idejercicio, idsesion);
    }

}
package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class EjercicioGrupomuscularIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 3419765032145241515L;
    @Column(name = "IDEJERCICIO", nullable = false)
    private Integer idejercicio;

    @Column(name = "IDGRUPOMUSCULAR", nullable = false)
    private Integer idgrupomuscular;

    public Integer getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(Integer idejercicio) {
        this.idejercicio = idejercicio;
    }

    public Integer getIdgrupomuscular() {
        return idgrupomuscular;
    }

    public void setIdgrupomuscular(Integer idgrupomuscular) {
        this.idgrupomuscular = idgrupomuscular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EjercicioGrupomuscularIdEntity entity = (EjercicioGrupomuscularIdEntity) o;
        return Objects.equals(this.idgrupomuscular, entity.idgrupomuscular) &&
                Objects.equals(this.idejercicio, entity.idejercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrupomuscular, idejercicio);
    }

}
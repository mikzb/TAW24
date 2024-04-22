package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class EjercicioGrupomuscularId implements java.io.Serializable {
    private static final long serialVersionUID = 3465168116365907589L;
    @Column(name = "idEjercicio", nullable = false)
    private Integer idEjercicio;

    @Column(name = "idGrupoMuscular", nullable = false)
    private Integer idGrupoMuscular;

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public Integer getIdGrupoMuscular() {
        return idGrupoMuscular;
    }

    public void setIdGrupoMuscular(Integer idGrupoMuscular) {
        this.idGrupoMuscular = idGrupoMuscular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EjercicioGrupomuscularId entity = (EjercicioGrupomuscularId) o;
        return Objects.equals(this.idEjercicio, entity.idEjercicio) &&
                Objects.equals(this.idGrupoMuscular, entity.idGrupoMuscular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEjercicio, idGrupoMuscular);
    }

}
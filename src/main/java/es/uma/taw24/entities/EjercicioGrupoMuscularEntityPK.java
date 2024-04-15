package es.uma.taw24.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class EjercicioGrupoMuscularEntityPK implements Serializable {
    @Column(name = "idEjercicio", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEjercicio;
    @Column(name = "idGrupoMuscular", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        if (o == null || getClass() != o.getClass()) return false;
        EjercicioGrupoMuscularEntityPK that = (EjercicioGrupoMuscularEntityPK) o;
        return Objects.equals(idEjercicio, that.idEjercicio) && Objects.equals(idGrupoMuscular, that.idGrupoMuscular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEjercicio, idGrupoMuscular);
    }
}

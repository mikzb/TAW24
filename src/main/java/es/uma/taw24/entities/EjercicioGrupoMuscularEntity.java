package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Ejercicio_GrupoMuscular", schema = "mydb")
@IdClass(EjercicioGrupoMuscularEntityPK.class)
public class EjercicioGrupoMuscularEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEjercicio", nullable = false)
    private Integer idEjercicio;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idGrupoMuscular", nullable = false)
    private Integer idGrupoMuscular;
    @ManyToOne
    @JoinColumn(name = "idEjercicio", referencedColumnName = "id", nullable = false)
    private EjercicioEntity ejercicioByIdEjercicio;
    @ManyToOne
    @JoinColumn(name = "idGrupoMuscular", referencedColumnName = "id", nullable = false)
    private GrupoMuscularEntity grupoMuscularByIdGrupoMuscular;

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
        EjercicioGrupoMuscularEntity that = (EjercicioGrupoMuscularEntity) o;
        return Objects.equals(idEjercicio, that.idEjercicio) && Objects.equals(idGrupoMuscular, that.idGrupoMuscular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEjercicio, idGrupoMuscular);
    }

    public EjercicioEntity getEjercicioByIdEjercicio() {
        return ejercicioByIdEjercicio;
    }

    public void setEjercicioByIdEjercicio(EjercicioEntity ejercicioByIdEjercicio) {
        this.ejercicioByIdEjercicio = ejercicioByIdEjercicio;
    }

    public GrupoMuscularEntity getGrupoMuscularByIdGrupoMuscular() {
        return grupoMuscularByIdGrupoMuscular;
    }

    public void setGrupoMuscularByIdGrupoMuscular(GrupoMuscularEntity grupoMuscularByIdGrupoMuscular) {
        this.grupoMuscularByIdGrupoMuscular = grupoMuscularByIdGrupoMuscular;
    }
}

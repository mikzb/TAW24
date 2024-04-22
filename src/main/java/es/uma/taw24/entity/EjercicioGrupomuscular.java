package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio_grupomuscular")
public class EjercicioGrupomuscular {
    @EmbeddedId
    private EjercicioGrupomuscularId id;

    @MapsId("idEjercicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEjercicio", nullable = false)
    private Ejercicio idEjercicio;

    @MapsId("idGrupoMuscular")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGrupoMuscular", nullable = false)
    private Grupomuscular idGrupoMuscular;

    public EjercicioGrupomuscularId getId() {
        return id;
    }

    public void setId(EjercicioGrupomuscularId id) {
        this.id = id;
    }

    public Ejercicio getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Ejercicio idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public Grupomuscular getIdGrupoMuscular() {
        return idGrupoMuscular;
    }

    public void setIdGrupoMuscular(Grupomuscular idGrupoMuscular) {
        this.idGrupoMuscular = idGrupoMuscular;
    }

}
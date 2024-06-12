package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio_grupomuscular")
public class EjercicioGrupomuscular {
    @EmbeddedId
    private EjercicioGrupomuscularId id;

    @MapsId("idejercicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEJERCICIO", nullable = false)
    private Ejercicio idejercicio;

    @MapsId("idgrupomuscular")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDGRUPOMUSCULAR", nullable = false)
    private Grupomuscular idgrupomuscular;

    public EjercicioGrupomuscularId getId() {
        return id;
    }

    public void setId(EjercicioGrupomuscularId id) {
        this.id = id;
    }

    public Ejercicio getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(Ejercicio idejercicio) {
        this.idejercicio = idejercicio;
    }

    public Grupomuscular getIdgrupomuscular() {
        return idgrupomuscular;
    }

    public void setIdgrupomuscular(Grupomuscular idgrupomuscular) {
        this.idgrupomuscular = idgrupomuscular;
    }

}
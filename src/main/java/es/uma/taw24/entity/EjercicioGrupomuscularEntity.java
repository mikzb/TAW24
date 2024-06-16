package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EJERCICIO_GRUPOMUSCULAR")
public class EjercicioGrupomuscularEntity {
    @EmbeddedId
    private EjercicioGrupomuscularIdEntity id;

    @MapsId("idejercicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEJERCICIO", nullable = false)
    private EjercicioEntity idejercicio;

    @MapsId("idgrupomuscular")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDGRUPOMUSCULAR", nullable = false)
    private GrupomuscularEntity idgrupomuscular;

    public EjercicioGrupomuscularIdEntity getId() {
        return id;
    }

    public void setId(EjercicioGrupomuscularIdEntity id) {
        this.id = id;
    }

    public EjercicioEntity getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(EjercicioEntity idejercicio) {
        this.idejercicio = idejercicio;
    }

    public GrupomuscularEntity getIdgrupomuscular() {
        return idgrupomuscular;
    }

    public void setIdgrupomuscular(GrupomuscularEntity idgrupomuscular) {
        this.idgrupomuscular = idgrupomuscular;
    }

}
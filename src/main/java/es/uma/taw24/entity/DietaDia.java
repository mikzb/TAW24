package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dieta_dia")
public class DietaDia {
    @EmbeddedId
    private DietaDiaId id;

    @MapsId("idDieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDieta", nullable = false)
    private Dieta idDieta;

    @MapsId("idDia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDia", nullable = false)
    private Dia idDia;

    public DietaDiaId getId() {
        return id;
    }

    public void setId(DietaDiaId id) {
        this.id = id;
    }

    public Dieta getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Dieta idDieta) {
        this.idDieta = idDieta;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

}
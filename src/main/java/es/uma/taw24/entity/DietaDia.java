package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dieta_dia")
public class DietaDia {
    @EmbeddedId
    private DietaDiaId id;

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private Dieta iddieta;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private Dia iddia;

    public DietaDiaId getId() {
        return id;
    }

    public void setId(DietaDiaId id) {
        this.id = id;
    }

    public Dieta getIddieta() {
        return iddieta;
    }

    public void setIddieta(Dieta iddieta) {
        this.iddieta = iddieta;
    }

    public Dia getIddia() {
        return iddia;
    }

    public void setIddia(Dia iddia) {
        this.iddia = iddia;
    }

}
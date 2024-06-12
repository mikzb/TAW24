package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dieta_dia")
public class DietaDiaEntity {
    @EmbeddedId
    private DietaDiaIdEntity id;

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private DietaEntity iddieta;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private DiaEntity iddia;

    public DietaDiaIdEntity getId() {
        return id;
    }

    public void setId(DietaDiaIdEntity id) {
        this.id = id;
    }

    public DietaEntity getIddieta() {
        return iddieta;
    }

    public void setIddieta(DietaEntity iddieta) {
        this.iddieta = iddieta;
    }

    public DiaEntity getIddia() {
        return iddia;
    }

    public void setIddia(DiaEntity iddia) {
        this.iddia = iddia;
    }

}
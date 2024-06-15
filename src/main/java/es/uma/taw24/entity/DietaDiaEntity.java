package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DIETA_DIA")
public class DietaDiaEntity {
    @EmbeddedId
    private DietaDiaIdEntity id = new DietaDiaIdEntity();

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private DietaEntity dieta;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private DiaEntity dia;

    public DietaDiaIdEntity getId() {
        return id;
    }

    public void setId(DietaDiaIdEntity id) {
        this.id = id;
    }

    public DietaEntity getDieta() {
        return dieta;
    }

    public void setDieta(DietaEntity iddieta) {
        this.dieta = iddieta;
    }

    public DiaEntity getDia() {
        return dia;
    }

    public void setDia(DiaEntity iddia) {
        this.dia = iddia;
    }

}
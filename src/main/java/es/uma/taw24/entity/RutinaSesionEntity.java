package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RUTINA_SESION")
public class RutinaSesionEntity {
    @EmbeddedId
    private RutinaSesionIdEntity id;

    @MapsId("idrutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDRUTINA", nullable = false)
    private RutinaEntity idrutina;

    @MapsId("idsesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSESION", nullable = false)
    private SesionEntityEntity idsesion;

    @Column(name = "DIADESEMANA", nullable = false, length = 10)
    private String diadesemana;

    public RutinaSesionIdEntity getId() {
        return id;
    }

    public void setId(RutinaSesionIdEntity id) {
        this.id = id;
    }

    public RutinaEntity getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(RutinaEntity idrutina) {
        this.idrutina = idrutina;
    }

    public SesionEntityEntity getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(SesionEntityEntity idsesion) {
        this.idsesion = idsesion;
    }

    public String getDiadesemana() {
        return diadesemana;
    }

    public void setDiadesemana(String diadesemana) {
        this.diadesemana = diadesemana;
    }

}
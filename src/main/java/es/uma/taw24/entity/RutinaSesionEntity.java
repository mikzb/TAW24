package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.RutinaSesion;
import jakarta.persistence.*;

@Entity
@Table(name = "RUTINA_SESION")
public class RutinaSesionEntity implements DTO<RutinaSesion> {
    @EmbeddedId
    private RutinaSesionIdEntity id = new RutinaSesionIdEntity();

    @MapsId("idrutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDRUTINA", nullable = false)
    private RutinaEntity idrutina;

    @MapsId("idsesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSESION", nullable = false)
    private SesionEntity idsesion;

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

    public SesionEntity getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(SesionEntity idsesion) {
        this.idsesion = idsesion;
    }

    public String getDiadesemana() {
        return diadesemana;
    }

    public void setDiadesemana(String diadesemana) {
        this.diadesemana = diadesemana;
    }

    public RutinaSesion toDTO() {
        RutinaSesion rutinaSesion = new RutinaSesion();
        rutinaSesion.setIdrutina(this.idrutina.toDTO());
        rutinaSesion.setIdsesion(this.idsesion.toDTO());
        rutinaSesion.setDiadesemana(this.diadesemana);
        return rutinaSesion;
    }
}
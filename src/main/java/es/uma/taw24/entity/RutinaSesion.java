package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina_sesion")
public class RutinaSesion {
    @EmbeddedId
    private RutinaSesionId id;

    @MapsId("idrutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDRUTINA", nullable = false)
    private Rutina idrutina;

    @MapsId("idsesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSESION", nullable = false)
    private Sesion idsesion;

    @Column(name = "DIADESEMANA", nullable = false, length = 10)
    private String diadesemana;

    public RutinaSesionId getId() {
        return id;
    }

    public void setId(RutinaSesionId id) {
        this.id = id;
    }

    public Rutina getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Rutina idrutina) {
        this.idrutina = idrutina;
    }

    public Sesion getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Sesion idsesion) {
        this.idsesion = idsesion;
    }

    public String getDiadesemana() {
        return diadesemana;
    }

    public void setDiadesemana(String diadesemana) {
        this.diadesemana = diadesemana;
    }

}
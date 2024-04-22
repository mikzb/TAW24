package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina_sesion")
public class RutinaSesion {
    @EmbeddedId
    private RutinaSesionId id;

    @MapsId("idRutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRutina", nullable = false)
    private Rutina idRutina;

    @MapsId("idSesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSesion", nullable = false)
    private Sesion idSesion;

    @Column(name = "diaDeSemana", nullable = false, length = 10)
    private String diaDeSemana;

    public RutinaSesionId getId() {
        return id;
    }

    public void setId(RutinaSesionId id) {
        this.id = id;
    }

    public Rutina getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Rutina idRutina) {
        this.idRutina = idRutina;
    }

    public Sesion getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Sesion idSesion) {
        this.idSesion = idSesion;
    }

    public String getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(String diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }

}
package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Rutina_Sesion", schema = "mydb")
@IdClass(RutinaSesionEntityPK.class)
public class RutinaSesionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idRutina", nullable = false)
    private Integer idRutina;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSesion", nullable = false)
    private Integer idSesion;
    @Basic
    @Column(name = "diaDeSemana", nullable = false, length = 10)
    private String diaDeSemana;
    @ManyToOne
    @JoinColumn(name = "idRutina", referencedColumnName = "id", nullable = false)
    private RutinaEntity rutinaByIdRutina;
    @ManyToOne
    @JoinColumn(name = "idSesion", referencedColumnName = "id", nullable = false)
    private SesionEntity sesionByIdSesion;

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public String getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(String diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RutinaSesionEntity that = (RutinaSesionEntity) o;
        return Objects.equals(idRutina, that.idRutina) && Objects.equals(idSesion, that.idSesion) && Objects.equals(diaDeSemana, that.diaDeSemana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRutina, idSesion, diaDeSemana);
    }

    public RutinaEntity getRutinaByIdRutina() {
        return rutinaByIdRutina;
    }

    public void setRutinaByIdRutina(RutinaEntity rutinaByIdRutina) {
        this.rutinaByIdRutina = rutinaByIdRutina;
    }

    public SesionEntity getSesionByIdSesion() {
        return sesionByIdSesion;
    }

    public void setSesionByIdSesion(SesionEntity sesionByIdSesion) {
        this.sesionByIdSesion = sesionByIdSesion;
    }
}

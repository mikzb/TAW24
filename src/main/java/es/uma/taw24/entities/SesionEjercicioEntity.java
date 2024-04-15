package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Sesion_Ejercicio", schema = "mydb")
@IdClass(SesionEjercicioEntityPK.class)
public class SesionEjercicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSesion", nullable = false)
    private Integer idSesion;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEjercicio", nullable = false)
    private Integer idEjercicio;
    @Basic
    @Column(name = "repeticiones", nullable = true)
    private Integer repeticiones;
    @Basic
    @Column(name = "duracion", nullable = true)
    private Integer duracion;
    @Basic
    @Column(name = "peso", nullable = true)
    private Short peso;
    @Basic
    @Column(name = "completado", nullable = false)
    private Boolean completado;
    @Basic
    @Column(name = "orden", nullable = false)
    private Integer orden;
    @Basic
    @Column(name = "velocidad", nullable = true)
    private Integer velocidad;
    @Basic
    @Column(name = "distancia", nullable = true)
    private Integer distancia;
    @ManyToOne
    @JoinColumn(name = "idSesion", referencedColumnName = "id", nullable = false)
    private SesionEntity sesionByIdSesion;
    @ManyToOne
    @JoinColumn(name = "idEjercicio", referencedColumnName = "id", nullable = false)
    private EjercicioEntity ejercicioByIdEjercicio;

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Short getPeso() {
        return peso;
    }

    public void setPeso(Short peso) {
        this.peso = peso;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SesionEjercicioEntity that = (SesionEjercicioEntity) o;
        return Objects.equals(idSesion, that.idSesion) && Objects.equals(idEjercicio, that.idEjercicio) && Objects.equals(repeticiones, that.repeticiones) && Objects.equals(duracion, that.duracion) && Objects.equals(peso, that.peso) && Objects.equals(completado, that.completado) && Objects.equals(orden, that.orden) && Objects.equals(velocidad, that.velocidad) && Objects.equals(distancia, that.distancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSesion, idEjercicio, repeticiones, duracion, peso, completado, orden, velocidad, distancia);
    }

    public SesionEntity getSesionByIdSesion() {
        return sesionByIdSesion;
    }

    public void setSesionByIdSesion(SesionEntity sesionByIdSesion) {
        this.sesionByIdSesion = sesionByIdSesion;
    }

    public EjercicioEntity getEjercicioByIdEjercicio() {
        return ejercicioByIdEjercicio;
    }

    public void setEjercicioByIdEjercicio(EjercicioEntity ejercicioByIdEjercicio) {
        this.ejercicioByIdEjercicio = ejercicioByIdEjercicio;
    }
}

package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sesion_ejercicio")
public class SesionEjercicio {
    @EmbeddedId
    private SesionEjercicioId id;

    @MapsId("idSesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSesion", nullable = false)
    private Sesion idSesion;

    @MapsId("idEjercicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEjercicio", nullable = false)
    private Ejercicio idEjercicio;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "peso")
    private Short peso;

    @Column(name = "completado", nullable = false)
    private Boolean completado = false;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    @Column(name = "velocidad")
    private Integer velocidad;

    @Column(name = "distancia")
    private Integer distancia;

    public SesionEjercicioId getId() {
        return id;
    }

    public void setId(SesionEjercicioId id) {
        this.id = id;
    }

    public Sesion getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Sesion idSesion) {
        this.idSesion = idSesion;
    }

    public Ejercicio getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Ejercicio idEjercicio) {
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

}
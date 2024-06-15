package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.SesionEjercicio;
import jakarta.persistence.*;

@Entity
@Table(name = "SESION_EJERCICIO")
public class SesionEjercicioEntity implements DTO<SesionEjercicio> {
    @EmbeddedId
    private SesionEjercicioIdEntity id = new SesionEjercicioIdEntity();

    @MapsId("idsesion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSESION", nullable = false)
    private SesionEntity idsesion;

    @MapsId("idejercicio")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEJERCICIO", nullable = false)
    private EjercicioEntity idejercicio;

    @Column(name = "SERIES")
    private Integer series;

    @Column(name = "REPETICIONES")
    private Integer repeticiones;

    @Column(name = "DURACION")
    private Integer duracion;

    @Column(name = "PESO")
    private Short peso;

    @Column(name = "COMPLETADO", nullable = false)
    private Boolean completado = false;
    
    @Column(name = "ORDEN", nullable = false)
    private Integer orden;

    @Column(name = "VELOCIDAD")
    private Integer velocidad;

    @Column(name = "DISTANCIA")
    private Integer distancia;

    public SesionEjercicioIdEntity getId() {
        return id;
    }

    public void setId(SesionEjercicioIdEntity id) {
        this.id = id;
    }

    public SesionEntity getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(SesionEntity idsesion) {
        this.idsesion = idsesion;
    }

    public EjercicioEntity getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(EjercicioEntity idejercicio) {
        this.idejercicio = idejercicio;
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

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    @Override
    public SesionEjercicio toDTO() {
        SesionEjercicio sesionEjercicio = new SesionEjercicio();
        sesionEjercicio.setSesion(this.idsesion.toDTO());
        sesionEjercicio.setEjercicio(this.idejercicio.toDTO());
        sesionEjercicio.setRepeticiones(this.repeticiones);
        sesionEjercicio.setSeries(this.series);
        sesionEjercicio.setDuracion(this.duracion);
        sesionEjercicio.setPeso(this.peso);
        sesionEjercicio.setCompletado(this.completado);
        sesionEjercicio.setVelocidad(this.velocidad);
        sesionEjercicio.setDistancia(this.distancia);
        return sesionEjercicio;
    }
}
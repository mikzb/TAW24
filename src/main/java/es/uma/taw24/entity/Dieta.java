package es.uma.taw24.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "dieta")
public class Dieta {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDietista", nullable = false)
    private Usuario idDietista;

    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getIdDietista() {
        return idDietista;
    }

    public void setIdDietista(Usuario idDietista) {
        this.idDietista = idDietista;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

}
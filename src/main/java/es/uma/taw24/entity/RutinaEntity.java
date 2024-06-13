package es.uma.taw24.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "RUTINA")
public class RutinaEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDENTRENADOR", nullable = false)
    private EntrenadorEntity identrenador;

    @Column(name = "FECHACREACION", nullable = false)
    private Instant fechacreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntrenadorEntity getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(EntrenadorEntity identrenador) {
        this.identrenador = identrenador;
    }

    public Instant getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Instant fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

}
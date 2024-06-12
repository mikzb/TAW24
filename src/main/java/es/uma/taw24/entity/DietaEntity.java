package es.uma.taw24.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "dieta")
public class DietaEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETISTA", nullable = false)
    private UsuarioEntity iddietista;

    @Column(name = "FECHACREACION", nullable = false)
    private Instant fechacreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioEntity getIddietista() {
        return iddietista;
    }

    public void setIddietista(UsuarioEntity iddietista) {
        this.iddietista = iddietista;
    }

    public Instant getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Instant fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

}
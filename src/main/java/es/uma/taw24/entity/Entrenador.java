package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "Crosstraining", nullable = false)
    private Boolean crosstraining = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getCrosstraining() {
        return crosstraining;
    }

    public void setCrosstraining(Boolean crosstraining) {
        this.crosstraining = crosstraining;
    }

}
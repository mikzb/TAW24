package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_dieta")
public class UsuarioDieta {
    @EmbeddedId
    private UsuarioDietaId id;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario idusuario;

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private Dieta iddieta;

    public UsuarioDietaId getId() {
        return id;
    }

    public void setId(UsuarioDietaId id) {
        this.id = id;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Dieta getIddieta() {
        return iddieta;
    }

    public void setIddieta(Dieta iddieta) {
        this.iddieta = iddieta;
    }

}
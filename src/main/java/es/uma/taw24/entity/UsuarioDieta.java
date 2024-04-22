package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_dieta")
public class UsuarioDieta {
    @EmbeddedId
    private UsuarioDietaId id;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @MapsId("idDieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDieta", nullable = false)
    private Dieta idDieta;

    public UsuarioDietaId getId() {
        return id;
    }

    public void setId(UsuarioDietaId id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Dieta getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Dieta idDieta) {
        this.idDieta = idDieta;
    }

}
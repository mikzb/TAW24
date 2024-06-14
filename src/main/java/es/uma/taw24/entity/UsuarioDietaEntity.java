package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO_DIETA")
public class UsuarioDietaEntity {
    @EmbeddedId
    private UsuarioDietaIdEntity id;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private UsuarioEntity usuario;

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private DietaEntity dieta;

    public UsuarioDietaIdEntity getId() {
        return id;
    }

    public void setId(UsuarioDietaIdEntity id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity idusuario) {
        this.usuario = idusuario;
    }

    public DietaEntity getDieta() {
        return dieta;
    }

    public void setDieta(DietaEntity iddieta) {
        this.dieta = iddieta;
    }

}
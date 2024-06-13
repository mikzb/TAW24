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
    private UsuarioEntity idusuario;

    @MapsId("iddieta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETA", nullable = false)
    private DietaEntity iddieta;

    public UsuarioDietaIdEntity getId() {
        return id;
    }

    public void setId(UsuarioDietaIdEntity id) {
        this.id = id;
    }

    public UsuarioEntity getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioEntity idusuario) {
        this.idusuario = idusuario;
    }

    public DietaEntity getIddieta() {
        return iddieta;
    }

    public void setIddieta(DietaEntity iddieta) {
        this.iddieta = iddieta;
    }

}
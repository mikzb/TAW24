package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ENTRENADOR_USUARIO")
public class EntrenadorUsuarioEntity {
    @EmbeddedId
    private EntrenadorUsuarioIdEntity id;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private UsuarioEntity idusuario;

    @MapsId("identrenador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDENTRENADOR", nullable = false)
    private EntrenadorEntity identrenador;

    public EntrenadorUsuarioIdEntity getId() {
        return id;
    }

    public void setId(EntrenadorUsuarioIdEntity id) {
        this.id = id;
    }

    public UsuarioEntity getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioEntity idusuario) {
        this.idusuario = idusuario;
    }

    public EntrenadorEntity getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(EntrenadorEntity identrenador) {
        this.identrenador = identrenador;
    }

}
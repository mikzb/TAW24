package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entrenador_usuario")
public class EntrenadorUsuario {
    @EmbeddedId
    private EntrenadorUsuarioId id;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario idusuario;

    @MapsId("identrenador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDENTRENADOR", nullable = false)
    private Entrenador identrenador;

    public EntrenadorUsuarioId getId() {
        return id;
    }

    public void setId(EntrenadorUsuarioId id) {
        this.id = id;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Entrenador getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(Entrenador identrenador) {
        this.identrenador = identrenador;
    }

}
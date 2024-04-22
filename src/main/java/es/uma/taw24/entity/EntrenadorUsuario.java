package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entrenador_usuario")
public class EntrenadorUsuario {
    @EmbeddedId
    private EntrenadorUsuarioId id;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @MapsId("idEntrenador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEntrenador", nullable = false)
    private Entrenador idEntrenador;

    public EntrenadorUsuarioId getId() {
        return id;
    }

    public void setId(EntrenadorUsuarioId id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Entrenador getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Entrenador idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

}
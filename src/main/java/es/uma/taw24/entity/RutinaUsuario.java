package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina_usuario")
public class RutinaUsuario {
    @EmbeddedId
    private RutinaUsuarioId id;

    @MapsId("idRutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRutina", nullable = false)
    private Rutina idRutina;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    public RutinaUsuarioId getId() {
        return id;
    }

    public void setId(RutinaUsuarioId id) {
        this.id = id;
    }

    public Rutina getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Rutina idRutina) {
        this.idRutina = idRutina;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}
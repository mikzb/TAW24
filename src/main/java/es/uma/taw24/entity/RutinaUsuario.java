package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina_usuario")
public class RutinaUsuario {
    @EmbeddedId
    private RutinaUsuarioId id;

    @MapsId("idrutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDRUTINA", nullable = false)
    private Rutina idrutina;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario idusuario;

    public RutinaUsuarioId getId() {
        return id;
    }

    public void setId(RutinaUsuarioId id) {
        this.id = id;
    }

    public Rutina getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Rutina idrutina) {
        this.idrutina = idrutina;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

}
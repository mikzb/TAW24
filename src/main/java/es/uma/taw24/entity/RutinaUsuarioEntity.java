package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RUTINA_USUARIO")
public class RutinaUsuarioEntity {
    @EmbeddedId
    private RutinaUsuarioIdEntity id;

    @MapsId("idrutina")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDRUTINA", nullable = false)
    private RutinaEntity idrutina;

    @MapsId("idusuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private UsuarioEntity idusuario;

    public RutinaUsuarioIdEntity getId() {
        return id;
    }

    public void setId(RutinaUsuarioIdEntity id) {
        this.id = id;
    }

    public RutinaEntity getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(RutinaEntity idrutina) {
        this.idrutina = idrutina;
    }

    public UsuarioEntity getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioEntity idusuario) {
        this.idusuario = idusuario;
    }

}
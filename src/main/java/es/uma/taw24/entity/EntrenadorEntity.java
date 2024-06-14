package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Entrenador;
import jakarta.persistence.*;

@Entity
@Table(name = "ENTRENADOR")
public class EntrenadorEntity implements DTO<Entrenador> {
    @Id
    @Column(name = "IDUSUARIO", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "CROSSTRAINING", nullable = false)
    private Boolean crosstraining = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Boolean getCrosstraining() {
        return crosstraining;
    }

    public void setCrosstraining(Boolean crosstraining) {
        this.crosstraining = crosstraining;
    }

    public Entrenador toDTO() {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(this.id);
        entrenador.setCrosstraining(this.crosstraining);
        entrenador.setUsuario(this.usuario.toDTO());
        return entrenador;
    }
}
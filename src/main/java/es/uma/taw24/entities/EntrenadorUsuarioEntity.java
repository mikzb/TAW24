package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Entrenador_Usuario", schema = "mydb")
@IdClass(EntrenadorUsuarioEntityPK.class)
public class EntrenadorUsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEntrenador", nullable = false)
    private Integer idEntrenador;
    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "idEntrenador", referencedColumnName = "idUsuario", nullable = false)
    private EntrenadorEntity entrenadorByIdEntrenador;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadorUsuarioEntity that = (EntrenadorUsuarioEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idEntrenador, that.idEntrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idEntrenador);
    }

    public UsuarioEntity getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioEntity usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public EntrenadorEntity getEntrenadorByIdEntrenador() {
        return entrenadorByIdEntrenador;
    }

    public void setEntrenadorByIdEntrenador(EntrenadorEntity entrenadorByIdEntrenador) {
        this.entrenadorByIdEntrenador = entrenadorByIdEntrenador;
    }
}

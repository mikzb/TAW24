package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Entrenador", schema = "mydb")
public class EntrenadorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "Crosstraining", nullable = false)
    private Boolean crosstraining;
    @OneToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;
    @OneToMany(mappedBy = "entrenadorByIdEntrenador")
    private Collection<EntrenadorUsuarioEntity> entrenadorUsuariosByIdUsuario;
    @OneToMany(mappedBy = "entrenadorByIdEntrenador")
    private Collection<RutinaEntity> rutinasByIdUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getCrosstraining() {
        return crosstraining;
    }

    public void setCrosstraining(Boolean crosstraining) {
        this.crosstraining = crosstraining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadorEntity that = (EntrenadorEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(crosstraining, that.crosstraining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, crosstraining);
    }

    public UsuarioEntity getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioEntity usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public Collection<EntrenadorUsuarioEntity> getEntrenadorUsuariosByIdUsuario() {
        return entrenadorUsuariosByIdUsuario;
    }

    public void setEntrenadorUsuariosByIdUsuario(Collection<EntrenadorUsuarioEntity> entrenadorUsuariosByIdUsuario) {
        this.entrenadorUsuariosByIdUsuario = entrenadorUsuariosByIdUsuario;
    }

    public Collection<RutinaEntity> getRutinasByIdUsuario() {
        return rutinasByIdUsuario;
    }

    public void setRutinasByIdUsuario(Collection<RutinaEntity> rutinasByIdUsuario) {
        this.rutinasByIdUsuario = rutinasByIdUsuario;
    }
}

package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Rutina_Usuario", schema = "mydb")
@IdClass(RutinaUsuarioEntityPK.class)
public class RutinaUsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idRutina", nullable = false)
    private Integer idRutina;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @ManyToOne
    @JoinColumn(name = "idRutina", referencedColumnName = "id", nullable = false)
    private RutinaEntity rutinaByIdRutina;
    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RutinaUsuarioEntity that = (RutinaUsuarioEntity) o;
        return Objects.equals(idRutina, that.idRutina) && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRutina, idUsuario);
    }

    public RutinaEntity getRutinaByIdRutina() {
        return rutinaByIdRutina;
    }

    public void setRutinaByIdRutina(RutinaEntity rutinaByIdRutina) {
        this.rutinaByIdRutina = rutinaByIdRutina;
    }

    public UsuarioEntity getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioEntity usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }
}

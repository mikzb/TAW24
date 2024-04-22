package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class EntrenadorUsuarioId implements java.io.Serializable {
    private static final long serialVersionUID = -3028379870513485914L;
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "idEntrenador", nullable = false)
    private Integer idEntrenador;

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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EntrenadorUsuarioId entity = (EntrenadorUsuarioId) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idEntrenador, entity.idEntrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idEntrenador);
    }

}
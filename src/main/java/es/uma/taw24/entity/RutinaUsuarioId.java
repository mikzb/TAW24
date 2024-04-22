package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class RutinaUsuarioId implements java.io.Serializable {
    private static final long serialVersionUID = -7293045356506901926L;
    @Column(name = "idRutina", nullable = false)
    private Integer idRutina;

    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RutinaUsuarioId entity = (RutinaUsuarioId) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idRutina, entity.idRutina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRutina);
    }

}
package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class UsuarioDietaId implements java.io.Serializable {
    private static final long serialVersionUID = 1118533186185145324L;
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "idDieta", nullable = false)
    private Integer idDieta;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioDietaId entity = (UsuarioDietaId) o;
        return Objects.equals(this.idDieta, entity.idDieta) &&
                Objects.equals(this.idUsuario, entity.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDieta, idUsuario);
    }

}
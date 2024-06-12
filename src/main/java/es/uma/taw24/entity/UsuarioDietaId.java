package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class UsuarioDietaId implements java.io.Serializable {
    private static final long serialVersionUID = 6340805097688364998L;
    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idusuario;

    @Column(name = "IDDIETA", nullable = false)
    private Integer iddieta;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIddieta() {
        return iddieta;
    }

    public void setIddieta(Integer iddieta) {
        this.iddieta = iddieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioDietaId entity = (UsuarioDietaId) o;
        return Objects.equals(this.iddieta, entity.iddieta) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddieta, idusuario);
    }

}
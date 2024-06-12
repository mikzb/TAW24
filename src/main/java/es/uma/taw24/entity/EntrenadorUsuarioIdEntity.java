package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class EntrenadorUsuarioIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = -8329979793619828811L;
    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idusuario;

    @Column(name = "IDENTRENADOR", nullable = false)
    private Integer identrenador;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(Integer identrenador) {
        this.identrenador = identrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EntrenadorUsuarioIdEntity entity = (EntrenadorUsuarioIdEntity) o;
        return Objects.equals(this.identrenador, entity.identrenador) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identrenador, idusuario);
    }

}
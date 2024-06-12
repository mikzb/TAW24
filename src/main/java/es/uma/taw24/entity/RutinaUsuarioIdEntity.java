package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class RutinaUsuarioIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 2259567083079270140L;
    @Column(name = "IDRUTINA", nullable = false)
    private Integer idrutina;

    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idusuario;

    public Integer getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Integer idrutina) {
        this.idrutina = idrutina;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RutinaUsuarioIdEntity entity = (RutinaUsuarioIdEntity) o;
        return Objects.equals(this.idrutina, entity.idrutina) &&
                Objects.equals(this.idusuario, entity.idusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrutina, idusuario);
    }

}
package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class RutinaSesionId implements java.io.Serializable {
    private static final long serialVersionUID = -2249870580244374816L;
    @Column(name = "IDRUTINA", nullable = false)
    private Integer idrutina;

    @Column(name = "IDSESION", nullable = false)
    private Integer idsesion;

    public Integer getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Integer idrutina) {
        this.idrutina = idrutina;
    }

    public Integer getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Integer idsesion) {
        this.idsesion = idsesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RutinaSesionId entity = (RutinaSesionId) o;
        return Objects.equals(this.idrutina, entity.idrutina) &&
                Objects.equals(this.idsesion, entity.idsesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrutina, idsesion);
    }

}
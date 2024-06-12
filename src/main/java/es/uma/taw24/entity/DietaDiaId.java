package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class DietaDiaId implements java.io.Serializable {
    private static final long serialVersionUID = -2918428673748996717L;
    @Column(name = "IDDIETA", nullable = false)
    private Integer iddieta;

    @Column(name = "IDDIA", nullable = false)
    private Integer iddia;

    public Integer getIddieta() {
        return iddieta;
    }

    public void setIddieta(Integer iddieta) {
        this.iddieta = iddieta;
    }

    public Integer getIddia() {
        return iddia;
    }

    public void setIddia(Integer iddia) {
        this.iddia = iddia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DietaDiaId entity = (DietaDiaId) o;
        return Objects.equals(this.iddieta, entity.iddieta) &&
                Objects.equals(this.iddia, entity.iddia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddieta, iddia);
    }

}
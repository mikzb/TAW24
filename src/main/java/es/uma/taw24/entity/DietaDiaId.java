package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class DietaDiaId implements java.io.Serializable {
    private static final long serialVersionUID = -8878480350431423480L;
    @Column(name = "idDieta", nullable = false)
    private Integer idDieta;

    @Column(name = "idDia", nullable = false)
    private Integer idDia;

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DietaDiaId entity = (DietaDiaId) o;
        return Objects.equals(this.idDieta, entity.idDieta) &&
                Objects.equals(this.idDia, entity.idDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDieta, idDia);
    }

}
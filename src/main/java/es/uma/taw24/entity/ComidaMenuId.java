package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ComidaMenuId implements java.io.Serializable {
    private static final long serialVersionUID = -2795143243716658712L;
    @Column(name = "IDCOMIDA", nullable = false)
    private Integer idcomida;

    @Column(name = "IDMENU", nullable = false)
    private Integer idmenu;

    public Integer getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Integer idcomida) {
        this.idcomida = idcomida;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ComidaMenuId entity = (ComidaMenuId) o;
        return Objects.equals(this.idcomida, entity.idcomida) &&
                Objects.equals(this.idmenu, entity.idmenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcomida, idmenu);
    }

}
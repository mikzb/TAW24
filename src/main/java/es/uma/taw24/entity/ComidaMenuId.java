package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ComidaMenuId implements java.io.Serializable {
    private static final long serialVersionUID = 1939026534812332363L;
    @Column(name = "idComida", nullable = false)
    private Integer idComida;

    @Column(name = "idMenu", nullable = false)
    private Integer idMenu;

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ComidaMenuId entity = (ComidaMenuId) o;
        return Objects.equals(this.idMenu, entity.idMenu) &&
                Objects.equals(this.idComida, entity.idComida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMenu, idComida);
    }

}
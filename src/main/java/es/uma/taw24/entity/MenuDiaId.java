package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MenuDiaId implements java.io.Serializable {
    private static final long serialVersionUID = 7263611997986438843L;
    @Column(name = "idMenu", nullable = false)
    private Integer idMenu;

    @Column(name = "idDia", nullable = false)
    private Integer idDia;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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
        MenuDiaId entity = (MenuDiaId) o;
        return Objects.equals(this.idDia, entity.idDia) &&
                Objects.equals(this.idMenu, entity.idMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDia, idMenu);
    }

}
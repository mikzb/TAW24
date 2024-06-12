package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MenuDiaIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 3005968475734015553L;
    @Column(name = "IDMENU", nullable = false)
    private Integer idmenu;

    @Column(name = "IDDIA", nullable = false)
    private Integer iddia;

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
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
        MenuDiaIdEntity entity = (MenuDiaIdEntity) o;
        return Objects.equals(this.iddia, entity.iddia) &&
                Objects.equals(this.idmenu, entity.idmenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddia, idmenu);
    }

}
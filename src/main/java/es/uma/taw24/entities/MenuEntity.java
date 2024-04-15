package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Menu", schema = "mydb")
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(mappedBy = "menuByIdMenu")
    private Collection<ComidaMenuEntity> comidaMenusById;
    @OneToMany(mappedBy = "menuByIdMenu")
    private Collection<MenuDiaEntity> menuDiasById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Collection<ComidaMenuEntity> getComidaMenusById() {
        return comidaMenusById;
    }

    public void setComidaMenusById(Collection<ComidaMenuEntity> comidaMenusById) {
        this.comidaMenusById = comidaMenusById;
    }

    public Collection<MenuDiaEntity> getMenuDiasById() {
        return menuDiasById;
    }

    public void setMenuDiasById(Collection<MenuDiaEntity> menuDiasById) {
        this.menuDiasById = menuDiasById;
    }
}

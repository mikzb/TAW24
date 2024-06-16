package es.uma.taw24.entity;

import es.uma.taw24.DTO.Menu;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MENU")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "menu")
    private List<ComidaMenuEntity> comidaMenus;

    @OneToMany(mappedBy = "menu")
    private List<MenuDiaEntity> menuDias;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu toDTO() {
        Menu menu = new Menu();
        menu.setId(this.id);
        return menu;
    }
}
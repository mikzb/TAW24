package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Menu;
import es.uma.taw24.DTO.MenuDia;
import jakarta.persistence.*;

@Entity
@Table(name = "MENU_DIA")
public class MenuDiaEntity implements DTO<MenuDia> {
    @EmbeddedId
    private MenuDiaIdEntity id = new MenuDiaIdEntity();

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private MenuEntity menu;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private DiaEntity dia;

    @Column(name = "COMPLETADO", nullable = false)
    private Boolean completado = false;

    public MenuDiaIdEntity getId() {
        return id;
    }

    public void setId(MenuDiaIdEntity id) {
        this.id = id;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity idmenu) {
        this.menu = idmenu;
    }

    public DiaEntity getDia() {
        return dia;
    }

    public void setDia(DiaEntity iddia) {
        this.dia = iddia;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    @Override
    public MenuDia toDTO() {
        MenuDia menuDia = new MenuDia();
        menuDia.setMenu(this.menu.toDTO());
        menuDia.setDia(this.dia.toDTO());
        menuDia.setCompletado(this.completado);
        return menuDia;
    }
}
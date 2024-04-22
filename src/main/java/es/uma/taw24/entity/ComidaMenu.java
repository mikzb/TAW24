package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comida_menu")
public class ComidaMenu {
    @EmbeddedId
    private ComidaMenuId id;

    @MapsId("idComida")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idComida", nullable = false)
    private Comida idComida;

    @MapsId("idMenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idMenu", nullable = false)
    private Menu idMenu;

    public ComidaMenuId getId() {
        return id;
    }

    public void setId(ComidaMenuId id) {
        this.id = id;
    }

    public Comida getIdComida() {
        return idComida;
    }

    public void setIdComida(Comida idComida) {
        this.idComida = idComida;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

}
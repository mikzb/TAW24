package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comida_menu")
public class ComidaMenu {
    @EmbeddedId
    private ComidaMenuId id;

    @MapsId("idcomida")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMIDA", nullable = false)
    private Comida idcomida;

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private Menu idmenu;

    public ComidaMenuId getId() {
        return id;
    }

    public void setId(ComidaMenuId id) {
        this.id = id;
    }

    public Comida getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Comida idcomida) {
        this.idcomida = idcomida;
    }

    public Menu getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Menu idmenu) {
        this.idmenu = idmenu;
    }

}
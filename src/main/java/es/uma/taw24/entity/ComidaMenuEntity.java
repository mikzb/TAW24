package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COMIDA_MENU")
public class ComidaMenuEntity {
    @EmbeddedId
    private ComidaMenuIdEntity id = new ComidaMenuIdEntity();

    @MapsId("idcomida")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMIDA", nullable = false)
    private ComidaEntity comida;

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private MenuEntity menu;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    public ComidaMenuIdEntity getId() {
        return id;
    }

    public void setId(ComidaMenuIdEntity id) {
        this.id = id;
    }

    public ComidaEntity getComida() {
        return comida;
    }

    public void setComida(ComidaEntity idcomida) {
        this.comida = idcomida;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity idmenu) {
        this.menu = idmenu;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
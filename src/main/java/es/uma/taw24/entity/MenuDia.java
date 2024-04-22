package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_dia")
public class MenuDia {
    @EmbeddedId
    private MenuDiaId id;

    @MapsId("idMenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idMenu", nullable = false)
    private Menu idMenu;

    @MapsId("idDia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDia", nullable = false)
    private Dia idDia;

    @Column(name = "Completado", nullable = false)
    private Boolean completado = false;

    public MenuDiaId getId() {
        return id;
    }

    public void setId(MenuDiaId id) {
        this.id = id;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

}
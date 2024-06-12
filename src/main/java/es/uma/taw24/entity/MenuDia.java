package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_dia")
public class MenuDia {
    @EmbeddedId
    private MenuDiaId id;

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private Menu idmenu;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private Dia iddia;

    @Column(name = "COMPLETADO", nullable = false)
    private Boolean completado = false;

    public MenuDiaId getId() {
        return id;
    }

    public void setId(MenuDiaId id) {
        this.id = id;
    }

    public Menu getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Menu idmenu) {
        this.idmenu = idmenu;
    }

    public Dia getIddia() {
        return iddia;
    }

    public void setIddia(Dia iddia) {
        this.iddia = iddia;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

}
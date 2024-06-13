package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MENU_DIA")
public class MenuDiaEntity {
    @EmbeddedId
    private MenuDiaIdEntity id;

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private MenuEntity idmenu;

    @MapsId("iddia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIA", nullable = false)
    private DiaEntity iddia;

    @Column(name = "COMPLETADO", nullable = false)
    private Boolean completado = false;

    public MenuDiaIdEntity getId() {
        return id;
    }

    public void setId(MenuDiaIdEntity id) {
        this.id = id;
    }

    public MenuEntity getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(MenuEntity idmenu) {
        this.idmenu = idmenu;
    }

    public DiaEntity getIddia() {
        return iddia;
    }

    public void setIddia(DiaEntity iddia) {
        this.iddia = iddia;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

}
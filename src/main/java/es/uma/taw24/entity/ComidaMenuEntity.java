package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COMIDA_MENU")
public class ComidaMenuEntity {
    @EmbeddedId
    private ComidaMenuIdEntity id;

    @MapsId("idcomida")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMIDA", nullable = false)
    private ComidaEntity idcomida;

    @MapsId("idmenu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDMENU", nullable = false)
    private MenuEntity idmenu;

    public ComidaMenuIdEntity getId() {
        return id;
    }

    public void setId(ComidaMenuIdEntity id) {
        this.id = id;
    }

    public ComidaEntity getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(ComidaEntity idcomida) {
        this.idcomida = idcomida;
    }

    public MenuEntity getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(MenuEntity idmenu) {
        this.idmenu = idmenu;
    }

}
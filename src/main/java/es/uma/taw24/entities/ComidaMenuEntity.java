package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Comida_Menu", schema = "mydb")
@IdClass(ComidaMenuEntityPK.class)
public class ComidaMenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idComida", nullable = false)
    private int idComida;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMenu", nullable = false)
    private int idMenu;
    @ManyToOne
    @JoinColumn(name = "idComida", referencedColumnName = "id", nullable = false)
    private ComidaEntity comidaByIdComida;
    @ManyToOne
    @JoinColumn(name = "idMenu", referencedColumnName = "id", nullable = false)
    private MenuEntity menuByIdMenu;

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComidaMenuEntity that = (ComidaMenuEntity) o;
        return idComida == that.idComida && idMenu == that.idMenu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComida, idMenu);
    }

    public ComidaEntity getComidaByIdComida() {
        return comidaByIdComida;
    }

    public void setComidaByIdComida(ComidaEntity comidaByIdComida) {
        this.comidaByIdComida = comidaByIdComida;
    }

    public MenuEntity getMenuByIdMenu() {
        return menuByIdMenu;
    }

    public void setMenuByIdMenu(MenuEntity menuByIdMenu) {
        this.menuByIdMenu = menuByIdMenu;
    }
}

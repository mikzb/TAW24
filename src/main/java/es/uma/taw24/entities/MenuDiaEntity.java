package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Menu_Dia", schema = "mydb")
@IdClass(MenuDiaEntityPK.class)
public class MenuDiaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMenu", nullable = false)
    private Integer idMenu;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDia", nullable = false)
    private Integer idDia;
    @Basic
    @Column(name = "Completado", nullable = false)
    private Boolean completado;
    @ManyToOne
    @JoinColumn(name = "idMenu", referencedColumnName = "id", nullable = false)
    private MenuEntity menuByIdMenu;
    @ManyToOne
    @JoinColumn(name = "idDia", referencedColumnName = "id", nullable = false)
    private DiaEntity diaByIdDia;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDiaEntity that = (MenuDiaEntity) o;
        return Objects.equals(idMenu, that.idMenu) && Objects.equals(idDia, that.idDia) && Objects.equals(completado, that.completado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMenu, idDia, completado);
    }

    public MenuEntity getMenuByIdMenu() {
        return menuByIdMenu;
    }

    public void setMenuByIdMenu(MenuEntity menuByIdMenu) {
        this.menuByIdMenu = menuByIdMenu;
    }

    public DiaEntity getDiaByIdDia() {
        return diaByIdDia;
    }

    public void setDiaByIdDia(DiaEntity diaByIdDia) {
        this.diaByIdDia = diaByIdDia;
    }
}

package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Dia", schema = "mydb")
public class DiaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;
    @OneToMany(mappedBy = "diaByIdDia")
    private Collection<DietaDiaEntity> dietaDiasById;
    @OneToMany(mappedBy = "diaByIdDia")
    private Collection<MenuDiaEntity> menuDiasById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaEntity diaEntity = (DiaEntity) o;
        return Objects.equals(id, diaEntity.id) && Objects.equals(fecha, diaEntity.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha);
    }

    public Collection<DietaDiaEntity> getDietaDiasById() {
        return dietaDiasById;
    }

    public void setDietaDiasById(Collection<DietaDiaEntity> dietaDiasById) {
        this.dietaDiasById = dietaDiasById;
    }

    public Collection<MenuDiaEntity> getMenuDiasById() {
        return menuDiasById;
    }

    public void setMenuDiasById(Collection<MenuDiaEntity> menuDiasById) {
        this.menuDiasById = menuDiasById;
    }
}

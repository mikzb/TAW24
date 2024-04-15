package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Comida", schema = "mydb")
public class ComidaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Descripcion", nullable = false, length = 150)
    private String descripcion;
    @OneToMany(mappedBy = "comidaByIdComida")
    private Collection<ComidaMenuEntity> comidaMenusById;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComidaEntity that = (ComidaEntity) o;
        return id == that.id && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    public Collection<ComidaMenuEntity> getComidaMenusById() {
        return comidaMenusById;
    }

    public void setComidaMenusById(Collection<ComidaMenuEntity> comidaMenusById) {
        this.comidaMenusById = comidaMenusById;
    }
}

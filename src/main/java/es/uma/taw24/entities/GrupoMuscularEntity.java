package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "GrupoMuscular", schema = "mydb")
public class GrupoMuscularEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @OneToMany(mappedBy = "grupoMuscularByIdGrupoMuscular")
    private Collection<EjercicioGrupoMuscularEntity> ejercicioGrupoMuscularsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMuscularEntity that = (GrupoMuscularEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    public Collection<EjercicioGrupoMuscularEntity> getEjercicioGrupoMuscularsById() {
        return ejercicioGrupoMuscularsById;
    }

    public void setEjercicioGrupoMuscularsById(Collection<EjercicioGrupoMuscularEntity> ejercicioGrupoMuscularsById) {
        this.ejercicioGrupoMuscularsById = ejercicioGrupoMuscularsById;
    }
}

package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.GrupoMuscular;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "GRUPOMUSCULAR")
public class GrupomuscularEntity implements Serializable, DTO<GrupoMuscular> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @ManyToMany(mappedBy = "gruposMusculares")
    private Set<EjercicioEntity> ejercicios;

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

    public Set<EjercicioEntity> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Set<EjercicioEntity> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public GrupoMuscular toDTO() {
        GrupoMuscular grupoMuscular = new GrupoMuscular();
        grupoMuscular.setId(this.id);
        grupoMuscular.setNombre(this.nombre);
        grupoMuscular.setEjercicios(this.ejercicios.stream().map(EjercicioEntity::toDTO).toList());
        return grupoMuscular;
    }

}
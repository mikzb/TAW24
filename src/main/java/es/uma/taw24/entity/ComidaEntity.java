package es.uma.taw24.entity;

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.DTO.DTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMIDA")
public class ComidaEntity implements DTO<Comida> {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false, length = 150)
    private String descripcion;

    @OneToMany(mappedBy = "comida")
    private List<ComidaMenuEntity> comidaMenus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Comida toDTO() {
        Comida c = new Comida();
        c.setId(this.id);
        c.setDescripcion(this.descripcion);
        return c;
    }
}
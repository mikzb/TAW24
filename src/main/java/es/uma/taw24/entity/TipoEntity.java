package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Tipo;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO")
public class TipoEntity implements Serializable, DTO<Tipo> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

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

    public Tipo toDTO() {
        Tipo t = new Tipo();
        t.setId(this.id);
        t.setNombre(this.nombre);
        return t;
    }

}
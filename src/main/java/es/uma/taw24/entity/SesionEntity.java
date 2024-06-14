package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Sesion;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "SESION")
public class SesionEntity implements Serializable, DTO<Sesion> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CROSSTRAINING", nullable = false)
    private Boolean crosstraining = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCrosstraining() {
        return crosstraining;
    }

    public void setCrosstraining(Boolean crosstraining) {
        this.crosstraining = crosstraining;
    }

    @Override
    public Sesion toDTO() {
        Sesion sesion = new Sesion();
        sesion.setId(this.id);
        sesion.setCrosstraining(this.crosstraining);
        return sesion;
    }
}
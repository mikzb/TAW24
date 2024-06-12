package es.uma.taw24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sesion")
public class Sesion {
    @Id
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

}
package es.uma.taw24.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "DIA")
public class DiaEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FECHA", nullable = false)
    private Instant fecha;

    @OneToMany(mappedBy = "dia")
    private List<MenuDiaEntity> menuDias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

}
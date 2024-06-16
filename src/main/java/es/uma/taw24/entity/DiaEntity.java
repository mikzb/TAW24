package es.uma.taw24.entity;

import es.uma.taw24.DTO.Dia;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "DIA")
public class DiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FECHA", nullable = false)
    private Instant fecha;

    @OneToMany(mappedBy = "dia")
    private List<MenuDiaEntity> menuDias;

    @OneToMany(mappedBy = "dia")
    private List<DietaDiaEntity> diaDietas;

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

    public Dia toDTO() {
        Dia dia = new Dia();
        dia.setId(this.id);
        dia.setFecha(this.fecha);
        return dia;
    }
}
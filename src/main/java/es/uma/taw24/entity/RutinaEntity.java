package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Rutina;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "RUTINA")
public class RutinaEntity implements Serializable, DTO<Rutina> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDENTRENADOR", nullable = false)
    private EntrenadorEntity identrenador;

    @Column(name = "FECHACREACION", nullable = false)
    private Instant fechacreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntrenadorEntity getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(EntrenadorEntity identrenador) {
        this.identrenador = identrenador;
    }

    public Instant getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Instant fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Rutina toDTO() {
        Rutina rutina = new Rutina();
        rutina.setId(this.id);
        rutina.setFechacreacion(this.fechacreacion);
        rutina.setEntrenador(this.identrenador.toDTO());
        return rutina;
    }

}
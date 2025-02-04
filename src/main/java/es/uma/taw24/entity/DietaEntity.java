package es.uma.taw24.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "DIETA")
public class DietaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDDIETISTA", nullable = false)
    private UsuarioEntity iddietista;

    @Column(name = "FECHACREACION", nullable = false)
    private Instant fechacreacion;

    @Column(name = "DESCRIPCION", nullable = false, length = 90)
    private String descripcion;

    @OneToMany(mappedBy = "dieta")
    private List<DietaDiaEntity> diaDietas;

    @OneToMany(mappedBy = "dieta")
    private List<UsuarioDietaEntity> dietaUsuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioEntity getIddietista() {
        return iddietista;
    }

    public void setIddietista(UsuarioEntity iddietista) {
        this.iddietista = iddietista;
    }

    public Instant getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Instant fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

}
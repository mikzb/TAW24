package es.uma.taw24.entity;

import es.uma.taw24.DTO.DTO;
import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "EJERCICIO")
public class EjercicioEntity implements DTO<Ejercicio> {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDTIPO", nullable = false)
    private TipoEntity idtipo;

    @Column(name = "NOMBRE", nullable = false, length = 90)
    private String nombre;

    @Column(name = "URL", length = 256)
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEntity getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(TipoEntity idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Ejercicio toDTO() {
        Ejercicio ej = new Ejercicio();
        ej.setId(this.id);
        ej.setNombre(this.nombre);
        ej.setUrl(this.url);
        ej.setTipo(this.idtipo.toDTO());
        return ej;
    }

}
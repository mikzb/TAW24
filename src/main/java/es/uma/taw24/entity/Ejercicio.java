package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDTIPO", nullable = false)
    private Tipo idtipo;

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

    public Tipo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipo idtipo) {
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

}
package es.uma.taw24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTipo", nullable = false)
    private Tipo idTipo;

    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "url", length = 256)
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
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
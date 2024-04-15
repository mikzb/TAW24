package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ejercicio", schema = "mydb")
public class EjercicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "idTipo", nullable = false)
    private Integer idTipo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;
    @Basic
    @Column(name = "url", nullable = true, length = 256)
    private String url;
    @ManyToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id", nullable = false)
    private TipoEntity tipoByIdTipo;
    @OneToMany(mappedBy = "ejercicioByIdEjercicio")
    private Collection<EjercicioGrupoMuscularEntity> ejercicioGrupoMuscularsById;
    @OneToMany(mappedBy = "ejercicioByIdEjercicio")
    private Collection<SesionEjercicioEntity> sesionEjerciciosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EjercicioEntity that = (EjercicioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idTipo, that.idTipo) && Objects.equals(nombre, that.nombre) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTipo, nombre, url);
    }

    public TipoEntity getTipoByIdTipo() {
        return tipoByIdTipo;
    }

    public void setTipoByIdTipo(TipoEntity tipoByIdTipo) {
        this.tipoByIdTipo = tipoByIdTipo;
    }

    public Collection<EjercicioGrupoMuscularEntity> getEjercicioGrupoMuscularsById() {
        return ejercicioGrupoMuscularsById;
    }

    public void setEjercicioGrupoMuscularsById(Collection<EjercicioGrupoMuscularEntity> ejercicioGrupoMuscularsById) {
        this.ejercicioGrupoMuscularsById = ejercicioGrupoMuscularsById;
    }

    public Collection<SesionEjercicioEntity> getSesionEjerciciosById() {
        return sesionEjerciciosById;
    }

    public void setSesionEjerciciosById(Collection<SesionEjercicioEntity> sesionEjerciciosById) {
        this.sesionEjerciciosById = sesionEjerciciosById;
    }
}

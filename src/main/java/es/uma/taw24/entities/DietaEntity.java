package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Dieta", schema = "mydb")
public class DietaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "idDietista", nullable = false)
    private Integer idDietista;
    @Basic
    @Column(name = "fechaCreacion", nullable = false)
    private Timestamp fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "idDietista", referencedColumnName = "id", nullable = false)
    private UsuarioEntity usuarioByIdDietista;
    @OneToMany(mappedBy = "dietaByIdDieta")
    private Collection<DietaDiaEntity> dietaDiasById;
    @OneToMany(mappedBy = "dietaByIdDieta")
    private Collection<UsuarioDietaEntity> usuarioDietasById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDietista() {
        return idDietista;
    }

    public void setIdDietista(Integer idDietista) {
        this.idDietista = idDietista;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietaEntity that = (DietaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idDietista, that.idDietista) && Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDietista, fechaCreacion);
    }

    public UsuarioEntity getUsuarioByIdDietista() {
        return usuarioByIdDietista;
    }

    public void setUsuarioByIdDietista(UsuarioEntity usuarioByIdDietista) {
        this.usuarioByIdDietista = usuarioByIdDietista;
    }

    public Collection<DietaDiaEntity> getDietaDiasById() {
        return dietaDiasById;
    }

    public void setDietaDiasById(Collection<DietaDiaEntity> dietaDiasById) {
        this.dietaDiasById = dietaDiasById;
    }

    public Collection<UsuarioDietaEntity> getUsuarioDietasById() {
        return usuarioDietasById;
    }

    public void setUsuarioDietasById(Collection<UsuarioDietaEntity> usuarioDietasById) {
        this.usuarioDietasById = usuarioDietasById;
    }
}

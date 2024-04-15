package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuario_Dieta", schema = "mydb")
@IdClass(UsuarioDietaEntityPK.class)
public class UsuarioDietaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDieta", nullable = false)
    private Integer idDieta;
    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    private UsuarioEntity usuarioByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "idDieta", referencedColumnName = "id", nullable = false)
    private DietaEntity dietaByIdDieta;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDietaEntity that = (UsuarioDietaEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idDieta, that.idDieta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDieta);
    }

    public UsuarioEntity getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(UsuarioEntity usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public DietaEntity getDietaByIdDieta() {
        return dietaByIdDieta;
    }

    public void setDietaByIdDieta(DietaEntity dietaByIdDieta) {
        this.dietaByIdDieta = dietaByIdDieta;
    }
}

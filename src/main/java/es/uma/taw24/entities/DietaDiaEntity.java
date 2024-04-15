package es.uma.taw24.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Dieta_Dia", schema = "mydb")
@IdClass(DietaDiaEntityPK.class)
public class DietaDiaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDieta", nullable = false)
    private Integer idDieta;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDia", nullable = false)
    private Integer idDia;
    @ManyToOne
    @JoinColumn(name = "idDieta", referencedColumnName = "id", nullable = false)
    private DietaEntity dietaByIdDieta;
    @ManyToOne
    @JoinColumn(name = "idDia", referencedColumnName = "id", nullable = false)
    private DiaEntity diaByIdDia;

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietaDiaEntity that = (DietaDiaEntity) o;
        return Objects.equals(idDieta, that.idDieta) && Objects.equals(idDia, that.idDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDieta, idDia);
    }

    public DietaEntity getDietaByIdDieta() {
        return dietaByIdDieta;
    }

    public void setDietaByIdDieta(DietaEntity dietaByIdDieta) {
        this.dietaByIdDieta = dietaByIdDieta;
    }

    public DiaEntity getDiaByIdDia() {
        return diaByIdDia;
    }

    public void setDiaByIdDia(DiaEntity diaByIdDia) {
        this.diaByIdDia = diaByIdDia;
    }
}

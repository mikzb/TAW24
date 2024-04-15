package es.uma.taw24.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class DietaDiaEntityPK implements Serializable {
    @Column(name = "idDieta", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDieta;
    @Column(name = "idDia", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDia;

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
        DietaDiaEntityPK that = (DietaDiaEntityPK) o;
        return Objects.equals(idDieta, that.idDieta) && Objects.equals(idDia, that.idDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDieta, idDia);
    }
}

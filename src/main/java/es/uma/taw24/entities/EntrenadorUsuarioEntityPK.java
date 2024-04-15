package es.uma.taw24.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class EntrenadorUsuarioEntityPK implements Serializable {
    @Column(name = "idUsuario", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "idEntrenador", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrenador;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadorUsuarioEntityPK that = (EntrenadorUsuarioEntityPK) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idEntrenador, that.idEntrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idEntrenador);
    }
}

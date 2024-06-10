package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioDieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDietaRepository extends JpaRepository<UsuarioDieta, Integer> {

    @Query("SELECT ud FROM UsuarioDieta ud WHERE ud.idUsuario = :usuarioId")
    int findDietaIdByUsuarioId(@Param("usuarioId") Integer usuarioId);
}

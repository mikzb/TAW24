package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioDieta;
import es.uma.taw24.entity.UsuarioDietaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDietaRepository extends JpaRepository<UsuarioDieta, UsuarioDietaId> {
    @Query("SELECT ud FROM UsuarioDieta ud WHERE ud.idusuario.id = :usuarioId")
    UsuarioDieta findByUsuarioId(@Param("usuarioId") Integer usuarioId);
}

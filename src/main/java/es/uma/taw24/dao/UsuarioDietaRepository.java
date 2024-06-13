package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioDietaEntity;
import es.uma.taw24.entity.UsuarioDietaIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioDietaRepository extends JpaRepository<UsuarioDietaEntity, UsuarioDietaIdEntity> {
    @Query("SELECT ud FROM UsuarioDietaEntity ud WHERE ud.idusuario.id = :usuarioId")
    UsuarioDietaEntity findByUsuarioId(@Param("usuarioId") Integer usuarioId);

    @Query("SELECT ud FROM UsuarioDietaEntity ud WHERE ud.iddieta.id = :dietaId")
    List<UsuarioDietaEntity> findByDietaId(@Param("dietaId") Integer dietaId);
}

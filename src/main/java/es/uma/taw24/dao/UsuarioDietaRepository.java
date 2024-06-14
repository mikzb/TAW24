/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.DietaEntity;
import es.uma.taw24.entity.UsuarioDietaEntity;
import es.uma.taw24.entity.UsuarioDietaIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioDietaRepository extends JpaRepository<UsuarioDietaEntity, UsuarioDietaIdEntity> {

    @Query("SELECT ud FROM UsuarioDietaEntity ud WHERE ud.dieta.id = :dietaId")
    List<UsuarioDietaEntity> findByDietaId(@Param("dietaId") Integer dietaId);

    @Modifying
    @Transactional
    @Query("UPDATE UsuarioDietaEntity ud SET ud.dieta = :dieta WHERE ud.usuario.id = :usuarioId")
    void updateDieta(@Param("usuarioId") Integer usuarioId, @Param("dieta") DietaEntity dieta);
}

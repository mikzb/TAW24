/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.DiaEntity;
import es.uma.taw24.entity.DietaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface DietaRepository extends JpaRepository<DietaEntity, Integer> {

    @Query("SELECT d FROM DietaEntity d WHERE d.iddietista.id = :dietistaId")
    List<DietaEntity> findByDietistaId(@RequestParam("dietistaId") Integer dietistaId);

    @Query("SELECT d FROM DietaEntity d WHERE d.iddietista.id = :dietistaId AND d.descripcion LIKE %:descripcion%")
    List<DietaEntity> findByDietistaIdAndDescripcion(Integer dietistaId, String descripcion);

    @Modifying
    @Query("DELETE FROM DietaEntity d WHERE d.id = :dietaId")
    void deleteById(@RequestParam("dietaId") Integer dietaId);

    @Query("SELECT d FROM DietaEntity d WHERE d.descripcion = :descripcion")
    Optional<DietaEntity> findByDescripcion(@RequestParam("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query("UPDATE DietaEntity d SET d.descripcion = :descripcion WHERE d.id = :dietaId")
    void update(@RequestParam("dietaId") Integer dietaId, @RequestParam("descripcion") String descripcion);
}

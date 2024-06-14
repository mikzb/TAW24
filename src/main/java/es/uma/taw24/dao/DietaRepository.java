/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.DietaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DietaRepository extends JpaRepository<DietaEntity, Integer> {

    @Query("SELECT d FROM DietaEntity d WHERE d.iddietista.id = :dietistaId")
    List<DietaEntity> findByDietistaId(@RequestParam("dietistaId") Integer dietistaId);

    @Modifying
    @Query("DELETE FROM DietaEntity d WHERE d.id = :dietaId")
    void deleteById(@RequestParam("dietaId") Integer dietaId);

    @Query("SELECT c  FROM DietaEntity d " +
            "JOIN DietaDiaEntity dd ON d.id = dd.id.iddieta " +
            "JOIN DiaEntity dia ON dd.id.iddia = dia.id " +
            "JOIN MenuDiaEntity md ON dia.id = md.id.iddia " +
            "JOIN MenuEntity m ON md.id.idmenu = m.id " +
            "JOIN ComidaMenuEntity cm ON m.id = cm.id.idmenu " +
            "JOIN ComidaEntity c ON cm.id.idcomida = c.id " +
            "WHERE d.id = :dietaId " +
            "ORDER BY dia.fecha")
    List<ComidaEntity> findComidasByDietaId(Integer dietaId);
}

package es.uma.taw24.dao;

import es.uma.taw24.entity.DietaDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietaDiaRepository extends JpaRepository<DietaDia, Integer> {
    @Query("SELECT dd FROM DietaDia dd WHERE dd.iddieta = :dietaId")
    List<DietaDia> findByDietaId(@Param("dietaId") Integer dietaId);
}

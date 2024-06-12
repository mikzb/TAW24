package es.uma.taw24.dao;

import es.uma.taw24.entity.DietaDiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietaDiaRepository extends JpaRepository<DietaDiaEntity, Integer> {
    @Query("SELECT dd FROM DietaDiaEntity dd WHERE dd.iddieta = :dietaId")
    List<DietaDiaEntity> findByDietaId(@Param("dietaId") Integer dietaId);
}

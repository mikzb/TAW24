package es.uma.taw24.dao;

import es.uma.taw24.entity.DiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface DiaRepository extends JpaRepository<DiaEntity, Integer> {

    @Query("SELECT d FROM DiaEntity d WHERE d.fecha = :fecha")
    Optional<DiaEntity> findByFecha(@RequestParam("fecha") Instant fecha);

    @Query("SELECT d FROM DiaEntity d " +
            "JOIN DietaDiaEntity dd ON d.id = dd.id.iddia " +
            "WHERE dd.id.iddieta = :dietaId " +
            "ORDER BY d.fecha ASC")
    List<DiaEntity> findDiasByDietaId(@RequestParam("dietaId") Integer dietaId);
}

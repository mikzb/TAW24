package es.uma.taw24.dao;

import es.uma.taw24.entity.RutinaSesionEntity;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RutinaSesionRepository extends JpaRepository<RutinaSesionEntity, Integer> {
    @Query("SELECT rs FROM RutinaSesionEntity rs WHERE rs.idrutina.id = :rutinaId")
    public List<RutinaSesionEntity> findByRutinaId(@RequestParam("rutinaId") Integer rutinaId);
}

package es.uma.taw24.dao;

import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<SesionEntity, Integer> {
}

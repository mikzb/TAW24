package es.uma.taw24.dao;

import es.uma.taw24.entity.EntrenadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<EntrenadorEntity, Integer> {
}

package es.uma.taw24.dao;

import es.uma.taw24.entity.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida, Integer> {
}

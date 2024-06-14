package es.uma.taw24.dao;

import es.uma.taw24.entity.RutinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RutinaRepository extends JpaRepository<RutinaEntity, Integer> {
    @Query("SELECT r FROM RutinaEntity r WHERE r.identrenador.id =:entrenadorId")
    public List<RutinaEntity> findByEntrenadorId(Integer entrenadorId);
}

package es.uma.taw24.dao;

import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SesionRepository extends JpaRepository<SesionEntity, Integer> {
    @Query("SELECT s FROM SesionEntity s WHERE s.id = :idS")
    public SesionEntity findByIdSesion(Integer idS);
}

package es.uma.taw24.dao;

import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.RutinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Integer> {
    @Query("SELECT s FROM EjercicioEntity s WHERE s.id = :idS")
    public EjercicioEntity findByIdEjercicio(Integer idS);
}

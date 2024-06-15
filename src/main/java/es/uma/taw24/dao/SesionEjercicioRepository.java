package es.uma.taw24.dao;

import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioIdEntity;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SesionEjercicioRepository extends JpaRepository<SesionEjercicioEntity, Integer> {
    @Query("SELECT se FROM SesionEjercicioEntity  se where se.idsesion = :idse and se.idejercicio = :idej")
    public SesionEjercicioEntity findBySesionEjercicioId(SesionEntity idse, EjercicioEntity idej);
}

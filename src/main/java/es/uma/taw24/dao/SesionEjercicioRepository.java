package es.uma.taw24.dao;

import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioIdEntity;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SesionEjercicioRepository extends JpaRepository<SesionEjercicioEntity, Integer> {
    @Query("SELECT se FROM SesionEjercicioEntity  se where se.idsesion = :idse and se.idejercicio = :idej")
    public SesionEjercicioEntity findBySesionEjercicioId(SesionEntity idse, EjercicioEntity idej);
    @Query("SELECT se FROM SesionEjercicioEntity se WHERE se.id.idsesion = :sesionId ORDER BY se.orden ASC")
    public List<SesionEjercicioEntity> findBySesionId(@RequestParam("sesionId") Integer sesionId);

    @Query("SELECT se FROM SesionEjercicioEntity se WHERE se.id.idsesion = :sesionId AND se.id.idejercicio = :ejercicioId")
    public SesionEjercicioEntity findBySesionIdAndEjercicioId(@RequestParam("sesionId") Integer sesionId, @RequestParam("ejercicioId") Integer ejercicioId);
}

/**
 * @author
 * Cristian Ruiz Martín: 60%
 * Álvaro Acedo Espejo: 20%
 * Mikolaj Zabski: 20%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioIdEntity;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SesionEjercicioRepository extends JpaRepository<SesionEjercicioEntity, Integer> {
    @Query("SELECT se FROM SesionEjercicioEntity  se where se.idsesion = :idse and se.idejercicio = :idej")
    public SesionEjercicioEntity findBySesionEjercicioId(SesionEntity idse, EjercicioEntity idej);

    @Query("SELECT se FROM SesionEjercicioEntity se WHERE se.id.idsesion = :sesionId ORDER BY se.orden ASC")
    public List<SesionEjercicioEntity> findBySesionId(@Param("sesionId") Integer sesionId);

    @Query("SELECT se FROM SesionEjercicioEntity se WHERE se.id.idsesion = :sesionId AND se.id.idejercicio = :ejercicioId")
    public SesionEjercicioEntity findBySesionIdAndEjercicioId(@Param("sesionId") Integer sesionId, @Param("ejercicioId") Integer ejercicioId);

    @Query("SELECT se FROM SesionEjercicioEntity se WHERE se.idsesion.id = :idSesion AND se.series >= :series AND se.repeticiones >= :repeticiones AND se.peso >= :peso AND se.completado = :completado")
    public List<SesionEjercicioEntity> findByFiltro(@Param("idSesion") Integer idSesion, @Param("series") Integer series, @Param("repeticiones") Integer repeticiones, @Param("peso") Integer peso, @Param("completado") Boolean completado);

    @Query("SELECT se FROM SesionEjercicioEntity se JOIN SesionEntity s on s.id=se.idsesion.id join RutinaSesionEntity rs on rs.idsesion.id=s.id where rs.idrutina.id= :rutinaId")
    List<SesionEjercicioEntity> findByRutinaId(Integer rutinaId);
}

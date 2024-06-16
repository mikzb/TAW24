/**
 * @author
 * Cristian Ruiz Martín: 70%
 * Álvaro Acedo Espejo: 30%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Integer>, EjercicioRepositoryCustom {

    @Query("SELECT e FROM EjercicioEntity e WHERE e.idtipo.nombre = :tipo")
    public List<EjercicioEntity> buscarPorTipo(@Param("tipo") String tipo);

    @Query("SELECT e FROM EjercicioEntity e WHERE e.nombre = :nombre")
    public EjercicioEntity findByNombre(@Param("nombre") String nombre);

    @Query("SELECT e FROM EjercicioEntity e WHERE e.id NOT IN (SELECT se.idejercicio.id FROM SesionEjercicioEntity se WHERE se.idsesion.id = :idSesion) AND e.idtipo.nombre = :tipo")
    List<EjercicioEntity> findNotContainedInSesionByTipo(@Param("idSesion") Integer idSesion, @Param("tipo") String tipo);
}
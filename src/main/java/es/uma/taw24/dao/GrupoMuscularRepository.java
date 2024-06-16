package es.uma.taw24.dao;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.entity.GrupomuscularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrupoMuscularRepository extends JpaRepository<GrupomuscularEntity, Integer> {

    @Query("select g from GrupomuscularEntity g where g.nombre LIKE %:nombre%")
    public List<GrupomuscularEntity> findByFiltro(String nombre);
}

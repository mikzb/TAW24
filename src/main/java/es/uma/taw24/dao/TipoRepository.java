package es.uma.taw24.dao;
/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoRepository extends JpaRepository<TipoEntity, Integer> {

    @Query("select t from TipoEntity t where t.nombre LIKE %:nombre%")
    public List<TipoEntity> findByFiltro(String nombre);
}

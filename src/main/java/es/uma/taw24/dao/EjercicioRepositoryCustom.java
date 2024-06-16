package es.uma.taw24.dao;

/**
 * @author Ignacy Borzestowski: 100%
 */
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.ui.FiltroEjercicio;

import java.util.List;

public interface EjercicioRepositoryCustom {
    List<EjercicioEntity> findByFiltro(FiltroEjercicio filtro);
}

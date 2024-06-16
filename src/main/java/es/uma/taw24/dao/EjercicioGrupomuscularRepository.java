package es.uma.taw24.dao;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EjercicioGrupomuscularRepository extends JpaRepository<EjercicioGrupomuscularEntity, Integer> {
    @Query("SELECT egm.idgrupomuscular FROM EjercicioGrupomuscularEntity egm WHERE egm.idejercicio.id = :ejercicioId")
    public List<GrupomuscularEntity> findByEjercicioId(@Param("ejercicioId") Integer ejercicioId);

    @Query("SELECT egm.idejercicio FROM EjercicioGrupomuscularEntity egm WHERE egm.idgrupomuscular.id = :grupoMuscularId")
    public List<EjercicioEntity> findByGrupoMuscularId(@Param("grupoMuscularId") Integer grupoMuscularId);

    @Query("SELECT egm FROM EjercicioGrupomuscularEntity egm WHERE egm.idejercicio.id = :ejercicioId AND egm.idgrupomuscular.id = :grupoMuscularId")
    public List<EjercicioGrupomuscularEntity> findByEjercicioIdAndGrupoMuscularId(@Param("ejercicioId") Integer ejercicioId, @Param("grupoMuscularId") Integer grupoMuscularId);
}

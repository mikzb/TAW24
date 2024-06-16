package es.uma.taw24.dao;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.GrupomuscularEntity;
import es.uma.taw24.entity.TipoEntity;
import es.uma.taw24.ui.FiltroEjercicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepositoryCustomImpl implements EjercicioRepositoryCustom {

    private final EntityManager entityManager;

    public EjercicioRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EjercicioEntity> findByFiltro(FiltroEjercicio filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EjercicioEntity> cq = cb.createQuery(EjercicioEntity.class);
        Root<EjercicioEntity> ejercicio = cq.from(EjercicioEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
            predicates.add(cb.like(ejercicio.get("nombre"), "%" + filtro.getNombre() + "%"));
        }
        if (filtro.getTipo() != null && !filtro.getTipo().isEmpty()) {
            Join<EjercicioEntity, TipoEntity> tipoJoin = ejercicio.join("idtipo");
            predicates.add(cb.like(tipoJoin.get("nombre"), "%" + filtro.getTipo() + "%"));
        }
        if (filtro.getGrupoMuscular() != null && !filtro.getGrupoMuscular().isEmpty()) {
            Join<EjercicioEntity, GrupomuscularEntity> grupoMuscularJoin = ejercicio.join("gruposMusculares");
            predicates.add(cb.like(grupoMuscularJoin.get("nombre"), "%" + filtro.getGrupoMuscular() + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}

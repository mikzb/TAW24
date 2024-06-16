package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.ui.FiltroUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom {

    private final EntityManager entityManager;

    public UsuarioRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UsuarioEntity> findByFiltro(FiltroUsuario filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsuarioEntity> query = cb.createQuery(UsuarioEntity.class);
        Root<UsuarioEntity> usuario = query.from(UsuarioEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getEmail() != null && !filtro.getEmail().isEmpty()) {
            predicates.add(cb.equal(usuario.get("email"), filtro.getEmail()));
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
            predicates.add(cb.like(usuario.get("nombre"), "%" + filtro.getNombre() + "%"));
        }
        if (filtro.getApellidos() != null && !filtro.getApellidos().isEmpty()) {
            predicates.add(cb.like(usuario.get("apellidos"), "%" + filtro.getApellidos() + "%"));
        }
        if (filtro.getSexo() != null && !filtro.getSexo().isEmpty()) {
            predicates.add(cb.equal(usuario.get("sexo"), filtro.getSexo()));
        }
        if (filtro.getEdad() != null && filtro.getEdad() > 0){
            predicates.add(cb.equal(usuario.get("edad"), filtro.getEdad()));
        }
        if (filtro.isPermisoAdmin()) {
            predicates.add(cb.equal(usuario.get("permisoAdmin"), true));
        }
        if (filtro.isPermisoEntrenador()) {
            predicates.add(cb.equal(usuario.get("permisoEntrenador"), true));
        }
        if (filtro.isPermisoDietista()) {
            predicates.add(cb.equal(usuario.get("permisoDietista"), true));
        }
        if (filtro.isPermisoCliente()) {
            predicates.add(cb.equal(usuario.get("permisoCliente"), true));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }

}
package es.uma.taw24.dao;

import es.uma.taw24.entity.GrupomuscularEntity;
import es.uma.taw24.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<TipoEntity, Integer> {
}

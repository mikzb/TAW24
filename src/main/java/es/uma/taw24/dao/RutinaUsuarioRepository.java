package es.uma.taw24.dao;

import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RutinaUsuarioRepository extends JpaRepository<RutinaUsuarioEntity, Integer> {
    @Query("SELECT r FROM RutinaUsuarioEntity r where r.idusuario.id = :id")
        public List<RutinaUsuarioEntity> findByIdusuario(@Param("id")Integer id);
}

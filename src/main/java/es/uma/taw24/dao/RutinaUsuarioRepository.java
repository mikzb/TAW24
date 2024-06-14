package es.uma.taw24.dao;

import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RutinaUsuarioRepository extends JpaRepository<RutinaUsuarioEntity, Integer> {
    @Query("SELECT ru.idrutina FROM RutinaUsuarioEntity ru WHERE ru.idusuario.id = :usuarioId and ru.idrutina.identrenador.id = :entrenadorId")
    public List<RutinaEntity> findByUsuarioIdAndEntrenadorId(Integer usuarioId, Integer entrenadorId);
}

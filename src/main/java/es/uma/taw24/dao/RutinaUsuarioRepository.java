/**
 * @author
 * Cristian Ruiz Martín: 50%
 * Álvaro Acedo Espejo: 50%
 */

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

    @Query("SELECT ru.idrutina FROM RutinaUsuarioEntity ru WHERE ru.idusuario.id = :usuarioId and ru.idrutina.identrenador.id = :entrenadorId")
    public List<RutinaEntity> findByUsuarioIdAndEntrenadorId(@Param("usuarioId") Integer usuarioId,@Param("entrenadorId") Integer entrenadorId);

    @Query("SELECT ru FROM RutinaUsuarioEntity ru WHERE ru.idrutina.id = :rutinaId AND ru.idusuario.id = :usuarioId")
    public RutinaUsuarioEntity findByRutinaIdAndUsuarioId(@Param("rutinaId") Integer rutinaId,@Param("usuarioId") Integer usuarioId);

    @Query("SELECT ru FROM RutinaUsuarioEntity ru WHERE ru.idrutina.id = :id")
    public List<RutinaUsuarioEntity> findByRutinaId(@Param("id") Integer id);
}

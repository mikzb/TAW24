/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.EntrenadorUsuarioEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntrenadorUsuarioRepository extends JpaRepository<EntrenadorUsuarioEntity, Integer> {
    @Query("SELECT eu.idusuario FROM EntrenadorUsuarioEntity eu WHERE eu.identrenador.id = :entrenadorId")
    public List<UsuarioEntity> findByEntrenadorId(@Param("entrenadorId") Integer entrenadorId);

}

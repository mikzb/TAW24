/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.EntrenadorUsuarioEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntrenadorUsuarioRepository extends JpaRepository<EntrenadorUsuarioEntity, Integer> {
    @Query("SELECT eu.idusuario FROM EntrenadorUsuarioEntity eu WHERE eu.identrenador.id = :entrenadorId")
     List<UsuarioEntity> findByEntrenadorId(@Param("entrenadorId") Integer entrenadorId);

    @Query("SELECT eu FROM EntrenadorUsuarioEntity eu WHERE eu.identrenador.id = :entrenadorId")
     List<EntrenadorUsuarioEntity> findRelationshipsByEntrenadorId(@Param("entrenadorId") Integer entrenadorId);

    @Query("SELECT eu FROM EntrenadorUsuarioEntity eu WHERE eu.idusuario.id = :usuarioId")
     List<EntrenadorUsuarioEntity> findRelationshipsByUsuarioId(@Param("usuarioId") Integer usuarioId);

    @Query("SELECT eu.identrenador FROM EntrenadorUsuarioEntity eu WHERE eu.idusuario.id = :usuarioId")
     List<EntrenadorEntity> findByUsuarioId(@Param("usuarioId") Integer usuarioId);
    
    @Query("SELECT eu FROM EntrenadorUsuarioEntity eu WHERE eu.idusuario.id = :usuarioId AND eu.identrenador.id = :entrenadorId")
     List<EntrenadorUsuarioEntity> findByEntrenadorIdAndUsuarioID(@Param("usuarioId") Integer usuarioId, @Param("entrenadorId") Integer entrenadorId);

}

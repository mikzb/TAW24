/**
 * @author
 * Ignacy Borzestowski: 50%
 * Pablo Rubia Arias: 50%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.DietaEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query("select a from UsuarioEntity a where a.email = :email and a.passwordhash = :pwd")
    public UsuarioEntity autentica (@Param("email") String email, @Param("pwd")String pwd);

    Optional<UsuarioEntity> findByEmail(String email);

    @Query("SELECT u FROM UsuarioEntity u " +
            "JOIN UsuarioDietaEntity ud ON u.id = ud.id.idusuario " +
            "JOIN DietaEntity d ON ud.id.iddieta = d.id " +
            "WHERE d.iddietista.id = :dietistaId")
    List<UsuarioEntity> findByDietistaId(Integer dietistaId);

    @Query("SELECT d FROM DietaEntity d " +
            "JOIN UsuarioDietaEntity ud ON d.id = ud.id.iddieta " +
            "JOIN UsuarioEntity u ON ud.id.idusuario = u.id " +
            "WHERE u.id = :usuarioId")
    DietaEntity findDietaByUsuarioId(@Param("usuarioId") Integer usuarioId);
}

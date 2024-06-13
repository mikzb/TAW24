package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query("select a from UsuarioEntity a where a.email = :email and a.passwordhash = :pwd")
    public UsuarioEntity autentica (@Param("email") String email, @Param("pwd")String pwd);

    Optional<UsuarioEntity> findByEmail(String email);
}

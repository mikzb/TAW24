package es.uma.taw24.dao;

import es.uma.taw24.entity.MenuDiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuDiaRepository extends JpaRepository<MenuDiaEntity, Integer> {
    @Query("SELECT m FROM MenuDia m WHERE m.iddia = :diaId")
    MenuDia findMenuDiaByDiaId(@Param("diaId") Integer diaId);
}

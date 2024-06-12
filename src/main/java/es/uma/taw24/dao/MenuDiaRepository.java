package es.uma.taw24.dao;

import es.uma.taw24.entity.MenuDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuDiaRepository extends JpaRepository<MenuDia, Integer> {
    @Query("SELECT m FROM MenuDia m WHERE m.iddia = :diaId")
    MenuDia findMenuDiaByDiaId(@Param("diaId") Integer diaId);
}

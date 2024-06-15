/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    @Query("SELECT m FROM MenuEntity m " +
            "JOIN MenuDiaEntity md ON m.id = md.id.idmenu " +
            "WHERE md.id.iddia = :diaId")
    MenuEntity findMenuByDiaId(Integer diaId);
}

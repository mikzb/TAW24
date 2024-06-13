package es.uma.taw24.dao;

import es.uma.taw24.entity.ComidaMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComidaMenuRepository extends JpaRepository<ComidaMenuEntity, Integer> {
    @Query("SELECT cm FROM ComidaMenuEntity cm WHERE cm.idmenu.id = :menuId")
    List<ComidaMenuEntity> findByMenuId(@Param("menuId") Integer menuId);
}

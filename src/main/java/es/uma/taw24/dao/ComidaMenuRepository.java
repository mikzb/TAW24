package es.uma.taw24.dao;

import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.ComidaMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ComidaMenuRepository extends JpaRepository<ComidaMenuEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ComidaMenuEntity cm SET cm.comida = :comidaNueva WHERE cm.id.idcomida = :comidaActualId AND cm.id.idmenu = :menuId")
    void update(@RequestParam("menuId") Integer menuId, @RequestParam("comidaActualId") Integer comidaActualId, @RequestParam("comidaNueva") ComidaEntity comidaNueva);

    @Query("SELECT cm FROM ComidaMenuEntity cm WHERE cm.id.idcomida = :comidaId")
    List<ComidaMenuEntity> findByComidaId(@RequestParam("comidaId") Integer comidaId);
}

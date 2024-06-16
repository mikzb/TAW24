package es.uma.taw24.dao;

import es.uma.taw24.entity.MenuDiaEntity;
import es.uma.taw24.entity.MenuDiaEntity;
import es.uma.taw24.entity.MenuDiaIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuDiaRepository extends JpaRepository<MenuDiaEntity, Integer> {
    @Query("SELECT m FROM MenuDiaEntity m WHERE m.dia.id = :diaId")
    MenuDiaEntity findByDiaId(@Param("diaId") Integer diaId);

    @Query("SELECT m FROM MenuDiaEntity m WHERE m.id = :id")
    MenuDiaEntity findByMenuDiaId(@Param("id") MenuDiaIdEntity id);

    @Query("SELECT m FROM MenuDiaEntity m JOIN DiaEntity d ON m.dia.id = d.id JOIN DietaDiaEntity dd ON d.id = dd.dia.id WHERE d.id = :diaId AND dd.dieta.id = :dietaId")
    List<MenuDiaEntity> findByDiaidAndDietaId(Integer diaId, Integer dietaId);

    @Query("SELECT m FROM MenuDiaEntity m JOIN DiaEntity d ON m.dia.id = d.id JOIN DietaDiaEntity dd ON d.id = dd.dia.id WHERE d.id = :diaId AND m.menu.id = :menuId")
    List<MenuDiaEntity> findByDiaidAndMenuId(Integer diaId, Integer menuId);
}

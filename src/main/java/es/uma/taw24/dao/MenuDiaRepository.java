package es.uma.taw24.dao;

<<<<<<< HEAD
=======
import es.uma.taw24.entity.MenuDia;
>>>>>>> 64fda0a03cf496f49c3511228231f603b5778b81
import es.uma.taw24.entity.MenuDiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuDiaRepository extends JpaRepository<MenuDiaEntity, Integer> {
<<<<<<< HEAD
    @Query("SELECT m FROM MenuDia m WHERE m.iddia = :diaId")
    MenuDia findMenuDiaByDiaId(@Param("diaId") Integer diaId);
=======
    @Query("SELECT m FROM MenuDiaEntity m WHERE m.iddia = :diaId")
    MenuDiaEntity findMenuDiaByDiaId(@Param("diaId") Integer diaId);
>>>>>>> 64fda0a03cf496f49c3511228231f603b5778b81
}

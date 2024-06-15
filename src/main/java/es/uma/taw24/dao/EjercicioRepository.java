package es.uma.taw24.dao;

import es.uma.taw24.entity.EjercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Integer> {
    @Query("SELECT s FROM EjercicioEntity s WHERE s.id = :idS")
    public EjercicioEntity findByIdEjercicio(Integer idS);
    @Query("SELECT e FROM EjercicioEntity e WHERE e.idtipo.nombre = :tipo")
    public List<EjercicioEntity> buscarPorTipo(@RequestParam("tipo") String tipo);

}
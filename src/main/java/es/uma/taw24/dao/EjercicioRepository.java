package es.uma.taw24.dao;

import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.EntrenadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Integer> {
}

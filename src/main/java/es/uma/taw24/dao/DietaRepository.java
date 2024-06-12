package es.uma.taw24.dao;

import es.uma.taw24.entity.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DietaRepository extends JpaRepository<Dieta, Integer> {

}

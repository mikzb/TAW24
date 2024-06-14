/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.dao;

import es.uma.taw24.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
}

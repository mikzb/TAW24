package es.uma.taw24.service;

import es.uma.taw24.DTO.Menu;
import es.uma.taw24.DTO.MenuDia;
import es.uma.taw24.dao.DiaRepository;
import es.uma.taw24.dao.MenuDiaRepository;
import es.uma.taw24.entity.MenuDiaEntity;
import es.uma.taw24.entity.MenuDiaIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDiaService extends DTOService<Menu, MenuDiaEntity>{

    @Autowired
    private DiaRepository diaRepository;

    @Autowired
    private MenuDiaRepository menuDiaRepository;

/*
    public void markDayAsCompleted(Integer diaId, Integer dietaId) {
        DiaEntity dia = diaRepository.findById(diaId).orElseThrow(() -> new NotFoundException("Dia not found with id: " + diaId));
        List<MenuDiaEntity> menuDias = menuDiaRepository.findByDiaidAndDietaId(diaId, dietaId);
        for (MenuDiaEntity menuDia : menuDias) {
            menuDia.setCompletado(true);
            menuDiaRepository.save(menuDia);
        }
    }*/

    public MenuDia findMenuDiaByDiaIdAndMenuId(MenuDiaIdEntity menuDiaId) {

        MenuDiaEntity menuDia = menuDiaRepository.findByMenuDiaId(menuDiaId);
        if (menuDia != null) {
            return menuDia.toDTO();
        } else {
            return null;
        }
    }

    public void guardar(MenuDia menuDia, MenuDiaIdEntity menuDiaId) {

        MenuDiaEntity menuDiaEntity = this.menuDiaRepository.findById(menuDia.getDia().getId()).orElse(new MenuDiaEntity());
        menuDiaEntity.setCompletado(menuDia.getCompletado());
        menuDiaRepository.save(menuDiaEntity);


    }
}

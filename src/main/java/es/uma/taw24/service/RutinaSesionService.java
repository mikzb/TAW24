package es.uma.taw24.service;

import es.uma.taw24.DTO.RutinaSesion;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.entity.RutinaSesionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaSesionService extends DTOService<RutinaSesion, RutinaSesionEntity> {
    @Autowired
    private RutinaSesionRepository rutinaSesionRepository;
    public void guardar(RutinaSesion rutinaSesion) {
        RutinaSesionEntity rutinaSesion2;
        if( !rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId()).equals(null) ){
            rutinaSesion2 = rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId());
        }else{
            rutinaSesion2 = new RutinaSesionEntity();
        }
        rutinaSesion2.setIdrutina(rutinaSesion.getIdrutina());
        rutinaSesion2.setIdsesion(rutinaSesion.getIdsesion());
        rutinaSesion2.setDiadesemana(rutinaSesion.getDiadesemana());
        this.rutinaSesionRepository.save(rutinaSesion2);
    }
}

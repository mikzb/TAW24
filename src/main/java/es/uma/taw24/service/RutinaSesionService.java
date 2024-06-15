/*
    Álvaro Acedo Espejo: 70%
    Cristian Ruiz Martín: 30%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.RutinaSesion;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaSesionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaSesionService extends DTOService<RutinaSesion, RutinaSesionEntity>{

    @Autowired
    private RutinaSesionRepository rutinaSesionRepository;
    @Autowired
    private RutinaRepository rutinaRepository;
    /*public void guardar(RutinaSesion rutinaSesion) {
        RutinaSesionEntity rutinaSesion2;
        if( !rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId()).equals(null) ){
            rutinaSesion2 = rutinaSesionRepository.findByRutinaSesionId(rutinaSesion.getId());
        }else{
            rutinaSesion2 = new RutinaSesionEntity();
        }
        RutinaEntity rutinaEntity = this.rutinaRepository.findById(rutinaSesion.getIdrutina().getId()).orElse(null);
        rutinaSesion2.setIdrutina(rutinaEntity);
        rutinaSesion2.setIdsesion(rutinaSesion.getIdsesion());
        rutinaSesion2.setDiadesemana(rutinaSesion.getDiadesemana());
        this.rutinaSesionRepository.save(rutinaSesion2);
    }*/

    public List<RutinaSesion> buscarPorIdRutina(Integer rutinaId) {
        List<RutinaSesionEntity> lista = this.rutinaSesionRepository.findByRutinaId(rutinaId);
        return this.entidadesADTO(lista);
    }

}

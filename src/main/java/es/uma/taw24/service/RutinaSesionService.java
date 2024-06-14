package es.uma.taw24.service;

import es.uma.taw24.DTO.RutinaSesion;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.entity.RutinaSesionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaSesionService extends DTOService<RutinaSesion, RutinaSesionEntity>{

    @Autowired
    private RutinaSesionRepository rutinaSesionRepository;

    public List<RutinaSesion> buscarPorIdRutina(Integer rutinaId) {
        List<RutinaSesionEntity> lista = this.rutinaSesionRepository.findByRutinaId(rutinaId);
        return this.entidadesADTO(lista);
    }

}

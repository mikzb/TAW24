package es.uma.taw24.service;

import es.uma.taw24.DTO.Sesion;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.dao.SesionRepository;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionService extends DTOService<Sesion, SesionEntity>{

    @Autowired
    private SesionRepository sesionRepository;

    public Sesion buscarSesion(Integer id) {
        return this.sesionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sesion con id: " + id + " no encontrada.")).toDTO();
    }
}

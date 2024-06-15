package es.uma.taw24.service;

import es.uma.taw24.DTO.Sesion;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.dao.SesionRepository;
import es.uma.taw24.entity.SesionEntity;
import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class SesionService extends DTOService<Sesion, SesionEntity>{

    @Autowired
    private SesionRepository sesionRepository;

    public SesionEntity buscarSesionPorId( int id) {
        return this.sesionRepository.findByIdSesion(id);
    }

    public void guardar(Sesion sesion){
        SesionEntity sesionEntity = this.sesionRepository.findById(sesion.getId()).orElse(new SesionEntity());
        sesionEntity.setCrosstraining(sesion.getCrosstraining());
        sesionRepository.save(sesionEntity);
    }
}

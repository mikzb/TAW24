package es.uma.taw24.service;

import es.uma.taw24.DTO.SesionEjercicio;
import es.uma.taw24.dao.SesionEjercicioRepository;
import es.uma.taw24.entity.SesionEjercicioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionEjercicioService extends DTOService<SesionEjercicio, SesionEjercicioEntity>{

    @Autowired
    private SesionEjercicioRepository sesionEjercicioRepository;

    public List<SesionEjercicio> buscarSesionEjercicioPorIdSesion(Integer sesionId) {
        List<SesionEjercicioEntity> lista = this.sesionEjercicioRepository.findBySesionId(sesionId);
        return this.entidadesADTO(lista);
    }
}

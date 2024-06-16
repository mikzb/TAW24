/**
 * @author
 * Cristian Ruiz Martín: 80%
 * Álvaro Acedo Espejo: 20%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.RutinaSesion;
import es.uma.taw24.DTO.Sesion;
import es.uma.taw24.DTO.SesionEjercicio;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.dao.SesionEjercicioRepository;
import es.uma.taw24.dao.SesionRepository;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaSesionEntity;
import es.uma.taw24.entity.SesionEjercicioEntity;
import es.uma.taw24.entity.SesionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SesionService extends DTOService<Sesion, SesionEntity>{

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private RutinaSesionRepository rutinaSesionRepository;

    @Autowired
    private SesionEjercicioRepository sesionEjercicioRepository;

    public SesionEntity buscarSesionPorId( int id) {
        return this.sesionRepository.findByIdSesion(id);
    }

    public void guardar(Sesion sesion){
        SesionEntity sesionEntity;
        if(sesion.getId() == null){
            sesionEntity = new SesionEntity();
        }
        else {
            sesionEntity = this.sesionRepository.findById(sesion.getId()).orElse(new SesionEntity());
        }
        //sesionEntity = this.sesionRepository.findById(sesion.getId()).orElse(new SesionEntity());
        sesionEntity.setCrosstraining(sesion.getCrosstraining());
        sesionRepository.save(sesionEntity);
        sesion.setId(sesionEntity.getId());
    }

    public Sesion buscarSesion(Integer id) {
        return this.sesionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sesion con id: " + id + " no encontrada.")).toDTO();
    }

    public void borrarSesion(Integer id) {
        List<RutinaSesionEntity> rutinaSesiones = this.rutinaSesionRepository.findBySesionId(id);
        this.rutinaSesionRepository.deleteAll(rutinaSesiones);
        List<SesionEjercicioEntity> sesionEjercicios = this.sesionEjercicioRepository.findBySesionId(id);
        this.sesionEjercicioRepository.deleteAll(sesionEjercicios);
        this.sesionRepository.deleteById(id);
    }
}

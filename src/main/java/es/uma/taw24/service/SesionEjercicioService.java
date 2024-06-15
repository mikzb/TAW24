package es.uma.taw24.service;

import es.uma.taw24.DTO.SesionEjercicio;
import es.uma.taw24.dao.SesionEjercicioRepository;
import es.uma.taw24.entity.SesionEjercicioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionEjercicioService extends DTOService<SesionEjercicio, SesionEjercicioRepository>{
    @Autowired
    private SesionEjercicioRepository sesionEjercicioRepository;

    public void guardar(SesionEjercicio sesionEjercicio) {
        SesionEjercicioEntity sesionEjercicio2;
        if( !sesionEjercicioRepository.findBySesionEjercicioId(sesionEjercicio.getIdsesion(), sesionEjercicio.getIdejercicio()).equals(null) ){
            sesionEjercicio2 = sesionEjercicioRepository.findBySesionEjercicioId(sesionEjercicio.getIdsesion(), sesionEjercicio.getIdejercicio());
        }else{
            sesionEjercicio2 = new SesionEjercicioEntity();
        }
        sesionEjercicio2.setIdejercicio(sesionEjercicio.getIdejercicio());
        sesionEjercicio2.setIdsesion(sesionEjercicio.getIdsesion());
        sesionEjercicio2.setPeso(sesionEjercicio.getPeso());
        sesionEjercicio2.setVelocidad(sesionEjercicio.getVelocidad());
        sesionEjercicio2.setRepeticiones(sesionEjercicio.getRepeticiones());
        sesionEjercicio2.setDuracion(sesionEjercicio.getDuracion());
        sesionEjercicio2.setDistancia(sesionEjercicio.getDistancia());
        sesionEjercicio2.setCompletado(sesionEjercicio.getCompletado());
        sesionEjercicio2.setOrden(sesionEjercicio.getOrden());
        sesionEjercicioRepository.save(sesionEjercicio2);
    }
}

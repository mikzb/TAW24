/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.SesionEjercicio;
import es.uma.taw24.dao.EjercicioRepository;
import es.uma.taw24.dao.SesionEjercicioRepository;
import es.uma.taw24.dao.SesionRepository;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.SesionEjercicioEntity;
import es.uma.taw24.entity.SesionEntity;
import es.uma.taw24.ui.FiltroSesionEjercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionEjercicioService extends DTOService<SesionEjercicio, SesionEjercicioEntity>{

    @Autowired
    private SesionEjercicioRepository sesionEjercicioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<SesionEjercicio> buscarSesionEjercicioPorIdSesion(Integer sesionId) {
        List<SesionEjercicioEntity> lista = this.sesionEjercicioRepository.findBySesionId(sesionId);
        return this.entidadesADTO(lista);
    }

    public List<SesionEjercicio> buscarSesionEjercicioPorFiltro(FiltroSesionEjercicio filtro) {
        List<SesionEjercicioEntity> lista = this.sesionEjercicioRepository.findByFiltro(filtro.getIdSesion(), filtro.getSeries(), filtro.getRepeticiones(), filtro.getPeso(), filtro.getCompletado());
        return this.entidadesADTO(lista);
    }

    public SesionEjercicio buscarSesionEjercicioPorIdSesionYEjercicio(Integer sesionId, Integer ejercicioId) {
        SesionEjercicioEntity sesionEjercicioEntity = this.sesionEjercicioRepository.findBySesionIdAndEjercicioId(sesionId, ejercicioId);
        return sesionEjercicioEntity.toDTO();
    }

    public void guardar(SesionEjercicio sesionEjercicio) {
        SesionEjercicioEntity sesionEjercicioEntity = this.sesionEjercicioRepository.findBySesionIdAndEjercicioId(sesionEjercicio.getSesion().getId(), sesionEjercicio.getEjercicio().getId());
        if (sesionEjercicioEntity == null) {
            sesionEjercicioEntity = new SesionEjercicioEntity();
        }
        SesionEntity sesion = this.sesionRepository.findById(sesionEjercicio.getSesion().getId()).orElse(null);
        EjercicioEntity ejercicio = this.ejercicioRepository.findById(sesionEjercicio.getEjercicio().getId()).orElse(null);
        sesionEjercicioEntity.setIdsesion(sesion);
        sesionEjercicioEntity.setIdejercicio(ejercicio);
        sesionEjercicioEntity.setRepeticiones(sesionEjercicio.getRepeticiones());
        sesionEjercicioEntity.setSeries(sesionEjercicio.getSeries());
        sesionEjercicioEntity.setPeso(sesionEjercicio.getPeso());
        sesionEjercicioEntity.setCompletado(sesionEjercicio.isCompletado());
        sesionEjercicioEntity.setDuracion(sesionEjercicio.getDuracion());
        sesionEjercicioEntity.setVelocidad(sesionEjercicio.getVelocidad());
        sesionEjercicioEntity.setDistancia(sesionEjercicio.getDistancia());
        this.sesionEjercicioRepository.save(sesionEjercicioEntity);
    }

    public void borrarSesionEjercicio(Integer idSesion, Integer idEjercicio) {
        SesionEjercicioEntity sesionEjercicioEntity = this.sesionEjercicioRepository.findBySesionIdAndEjercicioId(idSesion, idEjercicio);
        this.sesionEjercicioRepository.delete(sesionEjercicioEntity);
    }

    public List<SesionEjercicio> findSesionEjerciciosByRutinaId(Integer rutinaId) {
        return this.entidadesADTO(this.sesionEjercicioRepository.findByRutinaId(rutinaId));
    }


}

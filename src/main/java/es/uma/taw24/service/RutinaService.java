/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Rutina;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.entity.RutinaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService extends DTOService<Rutina, RutinaEntity> {

    @Autowired
    private RutinaRepository rutinaRepository;

    public List<Rutina> listarRutinas(Integer entrenadorId) {
        return this.entidadesADTO(this.rutinaRepository.findByEntrenadorId(entrenadorId));
    }

    public List<Rutina> listarRutinasEntidades(List<RutinaEntity> entidades) {
        return this.entidadesADTO(entidades);
    }

    public RutinaEntity buscarRutinaPorId(Integer id) {
        return this.rutinaRepository.findByIdRutina(id);
    }

}

/**
 * @author
 * Cristian Ruiz Martín: 60%
 * Álvaro Acedo espejo: 40%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Rutina;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.dao.RutinaUsuarioRepository;
import es.uma.taw24.entity.RutinaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService extends DTOService<Rutina, RutinaEntity> {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private RutinaUsuarioRepository rutinaUsuarioRepository;

    public List<Rutina> listarRutinas(Integer entrenadorId) {
        return this.entidadesADTO(this.rutinaRepository.findByEntrenadorId(entrenadorId));
    }

    public List<Rutina> listarRutinasEntidades(List<RutinaEntity> entidades) {
        return this.entidadesADTO(entidades);
    }

    public RutinaEntity buscarRutinaPorId(Integer id) {
        return this.rutinaRepository.findByIdRutina(id);
    }


    public List<Rutina> listarRutinas(Integer usuarioId, Integer entrenadorId) {
        return this.entidadesADTO(this.rutinaUsuarioRepository.findByUsuarioIdAndEntrenadorId(usuarioId, entrenadorId));
    }
    public Rutina buscarRutina(Integer id) {
        return this.rutinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Rutina con id: " + id + " no encontrada.")).toDTO();
    }
}

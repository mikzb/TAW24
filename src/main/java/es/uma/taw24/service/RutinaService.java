/**
 * @author
 * Cristian Ruiz Martín: 60%
 * Álvaro Acedo espejo: 40%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Rutina;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.dao.RutinaSesionRepository;
import es.uma.taw24.dao.RutinaUsuarioRepository;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaSesionEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import es.uma.taw24.ui.FiltroRutina;
import es.uma.taw24.ui.FiltroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutinaService extends DTOService<Rutina, RutinaEntity> {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private RutinaUsuarioRepository rutinaUsuarioRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private RutinaSesionRepository rutinaSesionRepository;

    public List<Rutina> listarRutinas(Integer entrenadorId) {
        return this.entidadesADTO(this.rutinaRepository.findByEntrenadorId(entrenadorId));
    }

    public List<Rutina> listarRutinasEntidades(List<RutinaEntity> entidades) {
        return this.entidadesADTO(entidades);
    }


    public List<Rutina> listarRutinas(Integer usuarioId, Integer entrenadorId) {
        return this.entidadesADTO(this.rutinaUsuarioRepository.findByUsuarioIdAndEntrenadorId(usuarioId, entrenadorId));
    }
    public Rutina buscarRutina(Integer id) {
        return this.rutinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Rutina con id: " + id + " no encontrada.")).toDTO();
    }

//    public HashMap<Rutina, Integer> listarRutinasConNumeroSesiones(Integer entrenadorId) {
//        List<RutinaEntity> rutinaEntities = this.rutinaRepository.findByEntrenadorId(entrenadorId);
//        List<Rutina> rutinas = this.entidadesADTO(rutinaEntities);
//        HashMap<Rutina, Integer> rutinasConNumeroSesiones = new HashMap<>();
//        for (Rutina rutina : rutinas) {
//            rutinasConNumeroSesiones.put(rutina, this.rutinaSesionRepository.countByRutinaId(rutina.getId()));
//        }
//        rutin
//        return rutinasConNumeroSesiones;
//    }

    public List<Rutina> listarRutinasPorFiltro(Integer entrenadorId, FiltroRutina filtroRutina) {
        List<RutinaEntity> rutinaEntities = this.rutinaUsuarioRepository.findByClienteIdAndFecha(entrenadorId, filtroRutina.getIdCliente(), filtroRutina.getLowerFechaInstant(), filtroRutina.getUpperFechaInstant());
        return this.entidadesADTO(rutinaEntities);
    }

    public void borrarRutina(Integer id) {
        List<RutinaUsuarioEntity> rutinaUsuarios = this.rutinaUsuarioRepository.findByRutinaId(id);
        this.rutinaUsuarioRepository.deleteAll(rutinaUsuarios);
        List<RutinaSesionEntity> rutinaSesiones = this.rutinaSesionRepository.findByRutinaId(id);
        this.rutinaSesionRepository.deleteAll(rutinaSesiones);
        this.rutinaRepository.deleteById(id);

    }

    public void guardar(Rutina rutina) {
        RutinaEntity rutinaEntity;
        if(rutina.getId() == null){
            rutinaEntity = new RutinaEntity();
            rutinaEntity.setFechacreacion(Instant.now());
        }
        else {
            rutinaEntity = this.rutinaRepository.findById(rutina.getId()).orElse(new RutinaEntity());
        }
        rutinaEntity.setIdentrenador(this.entrenadorRepository.findById(rutina.getEntrenador().getId()).orElseThrow(() -> new RuntimeException("Entrenador con id: " + rutina.getEntrenador().getId() + " no encontrado.")));
        this.rutinaRepository.save(rutinaEntity);

        rutina.setId(rutinaEntity.getId());
        rutina.setFechacreacion(rutinaEntity.getFechacreacion());
    }

    public List<RutinaEntity> findRutinasByClienteId(Integer id) {
       List<RutinaUsuarioEntity> rutinaUsuarioEntities = rutinaUsuarioRepository.findByIdusuario(id);
         return rutinaUsuarioEntities.stream().map(RutinaUsuarioEntity::getIdrutina).collect(Collectors.toList());

    }

    /*public void guardar(Rutina rutina) {
        RutinaEntity rutinaEntity = this.rutinaRepository.findById(rutina.getId()).orElse(new RutinaEntity());
        rutinaEntity.setFechacreacion(rutina.getFechacreacion());
        EntrenadorEntity entrenadorEntity = this.entrenadorRepository.findById(rutina.getIdentrenador().getId()).orElse(null);
        rutinaEntity.setIdentrenador(entrenadorEntity);
        rutinaRepository.save(rutinaEntity);
    }*/
}

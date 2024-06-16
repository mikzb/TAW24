/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.EntrenadorUsuarioEntity;
import es.uma.taw24.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrenadorService extends DTOService<Entrenador, EntrenadorEntity>{
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    public void guardarEntrenador(Entrenador entrenador) {
        EntrenadorEntity entrenadorEntity;
        if (entrenador.getId() == null) {
            entrenadorEntity = new EntrenadorEntity();
        } else {
            entrenadorEntity = entrenadorRepository.findById(entrenador.getId()).orElse(new EntrenadorEntity());
        }
            entrenadorEntity.setCrosstraining(entrenador.isCrosstraining());
            entrenadorEntity.setUsuario(this.usuarioRepository.findById(entrenador.getId()).orElse(null));
            this.entrenadorRepository.save(entrenadorEntity);
    }

    public boolean entrenadorExiste(int id) {
        return this.entrenadorRepository.findById(id).isPresent();
    }

/**    @author Ignacy Borzestowski
**/
    public List<Entrenador> listarEntrenadores() {
        return this.entidadesADTO(this.entrenadorRepository.findAll());
    }

    @Transactional
    public void borrarEntrenador(int id) {
        EntrenadorEntity entrenador = entrenadorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Entrenador not found with id: " + id));

        List<EntrenadorUsuarioEntity> entrenadorUsuarios = entrenadorUsuarioRepository.findRelationshipsByEntrenadorId(entrenador.getId());
        if (!entrenadorUsuarios.isEmpty()) {
            entrenadorUsuarioRepository.deleteAll(entrenadorUsuarios);
        }
        entrenadorRepository.deleteById(id);
    }

    /**    @author Ignacy Borzestowski
     **/
    public List<Entrenador> listarEntrenadoresDeUsuario(int idUsuario) {
      return this.entidadesADTO(this.entrenadorUsuarioRepository.findByUsuarioId(idUsuario));
    }

    public Entrenador buscarEntrenador(int id) {
        EntrenadorEntity entrenador = this.entrenadorRepository.findById(id).orElse(null);
        if (entrenador != null) {
            return entrenador.toDTO();
        } else {
            return null;
        }
    }
}

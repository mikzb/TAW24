/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService extends DTOService<Entrenador, EntrenadorEntity>{
    @Autowired
    private EntrenadorRepository entrenadorRespository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarEntrenador(Entrenador entrenador) {
            EntrenadorEntity entrenadorEntity = entrenadorRespository.findById(entrenador.getId()).orElse(new EntrenadorEntity());
            entrenadorEntity.setCrosstraining(entrenador.isCrosstraining());
            entrenadorEntity.setUsuario(this.usuarioRepository.findById(entrenador.getId()).orElse(null));
            this.entrenadorRespository.save(entrenadorEntity);
    }

    public boolean entrenadorExiste(int id) {
        return this.entrenadorRespository.findById(id).isPresent();
    }

    public void borrarEntrenador(int id) {
        this.entrenadorRespository.deleteById(id);
    }

    public Entrenador buscarEntrenador(int id) {
        EntrenadorEntity entrenador = this.entrenadorRespository.findById(id).orElse(null);
        if (entrenador != null) {
            return entrenador.toDTO();
        } else {
            return null;
        }
    }
}

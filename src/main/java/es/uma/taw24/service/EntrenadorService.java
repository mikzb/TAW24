/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService extends DTOService<Entrenador, EntrenadorEntity>{
    @Autowired
    private EntrenadorRepository entrenadorRespository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarEntrenador(Entrenador entrenador) {
        if (entrenadorRespository.findById(entrenador.getId()).isPresent()) {
            throw new IllegalArgumentException("El entrenador con id: " + entrenador.getId() + " ya existe.");
        }
            EntrenadorEntity entrenadorEntity = new EntrenadorEntity();
            entrenadorEntity.setCrosstraining(entrenador.isCrosstraining());
            entrenadorEntity.setUsuario(this.usuarioRepository.findById(entrenador.getId()).orElse(null));
            this.entrenadorRespository.save(entrenadorEntity);
    }

    public Entrenador buscarPorId(int id) {
        EntrenadorEntity entrenador = this.entrenadorRespository.findById(id).orElse(null);
        if (entrenador != null) {
            return entrenador.toDTO();
        } else {
            return null;
        }
    }
}

package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.EntrenadorUsuario;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.EntrenadorUsuarioEntity;
import es.uma.taw24.entity.EntrenadorUsuarioIdEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrenadorUsuarioService extends DTOService<EntrenadorUsuario, EntrenadorUsuarioEntity>{
    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Transactional
    public void asignarEntrenadorUsuario(EntrenadorUsuario entrenadorUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(entrenadorUsuario.getUsuarioId()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        EntrenadorEntity entrenador = entrenadorRepository.findById(entrenadorUsuario.getEntrenadorId()).orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));

        EntrenadorUsuarioIdEntity id = new EntrenadorUsuarioIdEntity();
        id.setIdusuario(usuario.getId());
        id.setIdentrenador(entrenador.getId());

        EntrenadorUsuarioEntity newAssignment = new EntrenadorUsuarioEntity();
        newAssignment.setId(id);
        newAssignment.setIdusuario(usuario);
        newAssignment.setIdentrenador(entrenador);

        entrenadorUsuarioRepository.save(newAssignment);
    }

    @Transactional
    public void desasignarEntrenadorUsuario(int idUsuario, int idEntrenador) {
        List<EntrenadorUsuarioEntity> entrenadorUsuarioEntities = entrenadorUsuarioRepository.findByEntrenadorIdAndUsuarioID(idUsuario, idEntrenador);
        if (!entrenadorUsuarioEntities.isEmpty()) {
            entrenadorUsuarioRepository.delete(entrenadorUsuarioEntities.getFirst());
        }
    }

}

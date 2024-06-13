/**
 * @author
 * Ignacy Borzestowski: 80%
 * Cristian Ruiz Martín: 20%
 */

package es.uma.taw24.service;

import es.uma.taw24.BCryptHashing;
import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.exception.DuplicateEmailException;
import es.uma.taw24.exception.UserNotFoundException;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends DTOService<Usuario, UsuarioEntity>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    @Autowired
    private EntrenadorService entrenadorService;

    public Usuario autenticar(String email, String password) {
        UsuarioEntity usuario = this.usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario con email:  " + email + " no encontrado."));


        if (BCryptHashing.checkPassword(password, usuario.getPasswordhash())) {
            return usuario.toDTO();
        } else {
            return null;
        }
    }

    public List<Usuario> listarUsuarios() {
        return this.entidadesADTO(this.usuarioRepository.findAll());
    }

    public List<Usuario> listarClientes(Integer idEntrenador){ return this.entidadesADTO(this.entrenadorUsuarioRepository.findByEntrenadorId(idEntrenador)); }

    public void guardarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new DuplicateEmailException("The email " + usuario.getEmail() + " is already in use.");
        }
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(usuario.getId()).orElse(new UsuarioEntity());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setPasswordhash(BCryptHashing.hashPassword(usuario.getPassword()));
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setApellidos(usuario.getApellidos());
        usuarioEntity.setEdad(usuario.getEdad());
        usuarioEntity.setSexo(usuario.getSexo());
        usuarioEntity.setPermisoAdmin(usuario.isPermisoAdmin());
        usuarioEntity.setPermisoEntrenador(usuario.isPermisoEntrenador());
        usuarioEntity.setPermisoDietista(usuario.isPermisoDietista());
        usuarioEntity.setPermisoCliente(usuario.isPermisoCliente());
        this.usuarioRepository.save(usuarioEntity);
        if(usuario.isPermisoEntrenador()){
            Entrenador entrenador = new Entrenador();
            entrenador.setCrosstraining(usuario.isCrosstraining());
            entrenador.setUsuario(usuarioEntity);
            entrenadorService.guardarEntrenador(entrenador);
        }
    }
}

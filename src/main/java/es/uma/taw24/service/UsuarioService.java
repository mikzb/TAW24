/**
 * @author
 * Ignacy Borzestowski: 65%
 * Cristian Ruiz Martín: 15%
 * Pablo Rubia Arias: 20%
 */

package es.uma.taw24.service;

import es.uma.taw24.BCryptHashing;
import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.DTO.UsuarioDietistaForm;
import es.uma.taw24.dao.EntrenadorUsuarioRepository;
import es.uma.taw24.dao.RutinaUsuarioRepository;
import es.uma.taw24.dao.UsuarioDietaRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.EntrenadorUsuarioEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import es.uma.taw24.entity.UsuarioDietaEntity;
import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.ui.FiltroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService extends DTOService<Usuario, UsuarioEntity>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorUsuarioRepository entrenadorUsuarioRepository;

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private UsuarioDietaRepository usuarioDietaRepository;

    @Autowired
    private RutinaUsuarioRepository rutinaUsuarioRepository;

    public Usuario autenticar(String email, String password) {
        UsuarioEntity usuario = this.usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuario con email:  " + email + " no encontrado."));


        if (BCryptHashing.checkPassword(password, usuario.getPasswordhash())) {
            return usuario.toDTO();
        } else {
            return null;
        }
    }

    public List<Usuario> listarDietistas() {
        return this.entidadesADTO(this.usuarioRepository.findDietistas());
    }

    public List<Usuario> listarUsuarios() {
        return this.entidadesADTO(this.usuarioRepository.findAll());
    }

    public Usuario buscarUsuario(int id) {
        return this.usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario con id: " + id + " no encontrado.")).toDTO();
    }

    public List<Usuario> listarClientes(Integer idEntrenador){ return this.entidadesADTO(this.entrenadorUsuarioRepository.findByEntrenadorId(idEntrenador)); }

    public boolean emailOcupado(String email) {
        return this.usuarioRepository.findByEmail(email).isPresent();
    }

    public void guardarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity;
        if (usuario.getId() == null) {
            usuarioEntity = new UsuarioEntity();
        } else {
            usuarioEntity = this.usuarioRepository.findById(usuario.getId()).orElse(new UsuarioEntity());
        }
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
            entrenador.setUsuario(usuario);
            entrenador.setId(usuarioEntity.getId());
            entrenadorService.guardarEntrenador(entrenador);
        }
    }

    public void asignarDietista(UsuarioDietistaForm usuarioDietistaForm) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(usuarioDietistaForm.getUsuarioId()).orElseThrow(() -> new NotFoundException("Usuario con id: " + usuarioDietistaForm.getUsuarioId()+ " no encontrado."));
        if (usuarioEntity.getIdDietista() == null) {
            usuarioEntity.setIdDietista(null);
            this.usuarioRepository.save(usuarioEntity);
        } else {
            UsuarioEntity dietista = this.usuarioRepository.findById(usuarioDietistaForm.getDietistaId()).orElseThrow(() -> new NotFoundException("Usuario con id: " + usuarioDietistaForm.getDietistaId() + " no encontrado."));
            usuarioEntity.setIdDietista(dietista);
            this.usuarioRepository.save(usuarioEntity);
        }
    }

    public void desasignarDietista(Usuario usuario) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new NotFoundException("Usuario con id: " + usuario.getId() + " no encontrado."));
        usuarioEntity.setIdDietista(null);
        this.usuarioRepository.save(usuarioEntity);
    }

    public List<Usuario> listarClientesPorDietistaId(Integer dietistaId) {
        List<UsuarioEntity> usuarios = this.usuarioRepository.findByDietistaId(dietistaId);
        List<Usuario> usuariosDTO = new ArrayList<>();

        for (UsuarioEntity usuario : usuarios) {
            Usuario usuarioDTO = new Usuario();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setApellidos(usuario.getApellidos());
            usuarioDTO.setEdad(usuario.getEdad());
            usuarioDTO.setSexo(usuario.getSexo());
            usuarioDTO.setPermisoAdmin(usuario.getPermisoAdmin());
            usuarioDTO.setPermisoEntrenador(usuario.getPermisoEntrenador());
            usuarioDTO.setPermisoDietista(usuario.getPermisoDietista());
            usuarioDTO.setPermisoCliente(usuario.getPermisoCliente());
            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;
    }

    public List<Usuario> listarUsuariosPorFiltro(FiltroUsuario filtroUsuario) {
        List<UsuarioEntity> usuarios = this.usuarioRepository.findByFiltro(filtroUsuario);
        return this.entidadesADTO(usuarios);
    }

    @Transactional
    public void borrarUsuario(int id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario not found with id: " + id));
        List<UsuarioDietaEntity> usuarioDietas = usuarioDietaRepository.findByUsuarioId(usuario.getId());
        if (!usuarioDietas.isEmpty()) {
            usuarioDietaRepository.deleteAll(usuarioDietas);
        }
        List<EntrenadorUsuarioEntity> entrenadorUsuarios = entrenadorUsuarioRepository.findRelationshipsByUsuarioId(usuario.getId());
        if (!entrenadorUsuarios.isEmpty()) {
            entrenadorUsuarioRepository.deleteAll(entrenadorUsuarios);
        }

        List<RutinaUsuarioEntity> rutinas = rutinaUsuarioRepository.findByIdusuario(usuario.getId());
        if (!rutinas.isEmpty()) {
            rutinaUsuarioRepository.deleteAll(rutinas);
        }

        Entrenador entrenador = this.entrenadorService.buscarEntrenador(id);
        if (entrenador != null) {
            this.entrenadorService.borrarEntrenador(id);
        }
        this.usuarioRepository.deleteById(id);
    }
}

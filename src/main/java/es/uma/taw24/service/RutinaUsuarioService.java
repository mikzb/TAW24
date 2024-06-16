package es.uma.taw24.service;

import es.uma.taw24.DTO.RutinaUsuario;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.dao.RutinaRepository;
import es.uma.taw24.dao.RutinaUsuarioRepository;
import es.uma.taw24.dao.UsuarioRepository;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RutinaUsuarioService extends DTOService<RutinaUsuario, RutinaUsuarioEntity>{

    @Autowired
    private RutinaUsuarioRepository rutinaUsuarioRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;


    public List<RutinaUsuario> listarRutinasCliente(@Param("id") Integer clienteId) {
        return this.entidadesADTO(this.rutinaUsuarioRepository.findByIdusuario(clienteId));
    }

    public List<RutinaUsuario> buscarRutinaUsuarioPorRutinaId(@Param("id") Integer rutinaId) {
        return this.entidadesADTO(this.rutinaUsuarioRepository.findByRutinaId(rutinaId));
    }

    public void guardar(RutinaUsuario rutinaUsuario) {
        RutinaUsuarioEntity rutinaUsuarioEntity = this.rutinaUsuarioRepository.findByRutinaIdAndUsuarioId(rutinaUsuario.getRutina().getId(), rutinaUsuario.getUsuario().getId());
        RutinaEntity rutinaEntity;
        if(rutinaUsuarioEntity == null){
            rutinaUsuarioEntity = new RutinaUsuarioEntity();
        }
        if(rutinaUsuario.getRutina().getId() == null){
            rutinaEntity = new RutinaEntity();
            rutinaEntity.setFechacreacion(Instant.now());
            rutinaEntity.setIdentrenador(this.entrenadorRepository.findById(rutinaUsuario.getRutina().getEntrenador().getId()).orElse(null));
            rutinaRepository.save(rutinaEntity);

        }
        else {
            rutinaEntity = this.rutinaRepository.findById(rutinaUsuario.getRutina().getId()).orElse(null);
        }
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(rutinaUsuario.getUsuario().getId()).orElse(null);
        rutinaUsuarioEntity.setIdrutina(rutinaEntity);
        rutinaUsuarioEntity.setIdusuario(usuarioEntity);
        this.rutinaUsuarioRepository.save(rutinaUsuarioEntity);
    }
}

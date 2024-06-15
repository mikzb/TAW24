package es.uma.taw24.service;

import es.uma.taw24.DTO.Rutina;
import es.uma.taw24.DTO.RutinaUsuario;
import es.uma.taw24.dao.RutinaUsuarioRepository;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.RutinaUsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaUsuarioService extends DTOService<RutinaUsuario, RutinaUsuarioEntity>{
    @Autowired
    private RutinaUsuarioRepository rutinaUsuarioRepository;

    public List<RutinaUsuario> listarRutinasCliente(@Param("id") Integer clienteId) {
        return this.entidadesADTO(this.rutinaUsuarioRepository.findByIdusuario(clienteId));
    }
}

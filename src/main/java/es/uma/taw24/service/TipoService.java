package es.uma.taw24.service;

import es.uma.taw24.DTO.Tipo;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.TipoRepository;
import es.uma.taw24.entity.TipoEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService extends DTOService<Tipo, TipoEntity>{

    @Autowired
    TipoRepository tipoRepository;

    public void guardarTipo(Tipo tipo) {
        TipoEntity tipoEntity = tipoRepository.findById(tipo.getId()).orElse(new TipoEntity());
        tipoEntity.setNombre(tipo.getNombre());
        tipoRepository.save(tipoEntity);
    }

    public List<Tipo> listarTipos() {
        return this.entidadesADTO(this.tipoRepository.findAll());
    }

    public boolean tipoExiste(int id) {
        return this.tipoRepository.findById(id).isPresent();
    }

    public void borrarTipo(int id) {
        this.tipoRepository.deleteById(id);
    }

    public Tipo buscarPorId(int id) {
        TipoEntity tipo = this.tipoRepository.findById(id).orElse(null);
        if (tipo != null) {
            return tipo.toDTO();
        } else {
            return null;
        }
    }
}

package es.uma.taw24.service;

import es.uma.taw24.DTO.Entrenador;
import es.uma.taw24.dao.EntrenadorRepository;
import es.uma.taw24.entity.EntrenadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService extends DTOService<Entrenador, EntrenadorEntity>{
    @Autowired
    private EntrenadorRepository entrenadorRespository;

    public void guardarEntrenador(Entrenador entrenador) {
        if (entrenadorRespository.findById(entrenador.getId()).isPresent()) {
            throw new IllegalArgumentException("El entrenador con id: " + entrenador.getId() + " ya existe.");
        }
            EntrenadorEntity entrenadorEntity = new EntrenadorEntity();
            entrenadorEntity.setCrosstraining(entrenador.isCrosstraining());
            entrenadorEntity.setUsuario(entrenador.getUsuario());
            this.entrenadorRespository.save(entrenadorEntity);
    }
}

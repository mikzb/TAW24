package es.uma.taw24.service;

import es.uma.taw24.DTO.Comida;
import es.uma.taw24.DTO.DTO;
import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService extends DTOService<Comida, ComidaEntity>{
    @Autowired
    private ComidaRepository comidaRepository;

    public List<Comida> listarComidas() {
        return this.entidadesADTO(this.comidaRepository.findAll());
    }
}

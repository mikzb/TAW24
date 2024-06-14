/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.service;
import es.uma.taw24.DTO.Comida;
import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    public List<Comida> listarComidas() {
        List<ComidaEntity> comidas =  this.comidaRepository.findAll();
        List<Comida> comidasDTO = new ArrayList<>();

        for (ComidaEntity comida : comidas) {
            Comida comidaDTO = new Comida();
            comidaDTO.setId(comida.getId());
            comidaDTO.setDescripcion(comida.getDescripcion());
            comidasDTO.add(comidaDTO);
        }

        return comidasDTO;
    }

    public Comida buscarPorId(Integer id) {
        ComidaEntity comida = this.comidaRepository.findById(id).orElse(null);
        Comida comidaDTO = new Comida();

        comidaDTO.setId(comida.getId());
        comidaDTO.setDescripcion(comida.getDescripcion());

        return comidaDTO;
    }
}

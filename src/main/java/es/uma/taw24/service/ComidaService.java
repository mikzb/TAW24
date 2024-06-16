package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 50%
 * @author Pablo Rubia Arias: 50%
 */


import es.uma.taw24.DTO.Comida;
import es.uma.taw24.dao.ComidaMenuRepository;
import es.uma.taw24.dao.ComidaRepository;
import es.uma.taw24.entity.ComidaEntity;
import es.uma.taw24.entity.ComidaMenuEntity;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.ui.FiltroComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService extends DTOService<Comida, ComidaEntity>{
    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private ComidaMenuRepository comidaMenuRepository;

    public List<Comida> listarComidas() {
        return this.entidadesADTO(this.comidaRepository.findAll());
    }

    public void guardarComida(Comida comida) {
        ComidaEntity comidaEntity;
        if (comida.getId() == null) {
            comidaEntity = new ComidaEntity();
        } else {
            comidaEntity = comidaRepository.findById(comida.getId()).orElse(new ComidaEntity());
        }
        comidaEntity.setDescripcion(comida.getDescripcion());
        comidaRepository.save(comidaEntity);
    }

    public Comida buscarPorId(int id) {
        ComidaEntity comida = this.comidaRepository.findById(id).orElse(null);
        if (comida != null) {
            return comida.toDTO();
        } else {
            return null;
        }
    }

    public void borrarComida(int id) {
        ComidaEntity comida = this.comidaRepository.findById(id).orElseThrow(() -> new NotFoundException("Ejercicio not found with id: " + id));
        List<ComidaMenuEntity> comidasMenu = comidaMenuRepository.findByComidaId(comida.getId());
        if (!comidasMenu.isEmpty()) {
            comidaMenuRepository.deleteAll(comidasMenu);
        }
        this.comidaRepository.deleteById(id);
    }

    public List<Comida> listarComidasPorFiltro(FiltroComida filtro) {
        return this.entidadesADTO(this.comidaRepository.findByFiltro(filtro.getDescripcion()));
    }
}

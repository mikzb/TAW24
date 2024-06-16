package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 60%
 * @author Cristian Ruiz Martín: 20%
 * @author Álvaro Acedo Espejo: 20%
 */


import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.dao.EjercicioGrupomuscularRepository;
import es.uma.taw24.dao.EjercicioRepository;
import es.uma.taw24.dao.TipoRepository;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.EjercicioGrupomuscularEntity;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.ui.FiltroEjercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService extends DTOService<Ejercicio, EjercicioEntity>{

    @Autowired
    private EjercicioRepository ejercicioRepository;
    @Autowired
    private EjercicioGrupomuscularRepository ejercicioGrupomuscularRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public List<Ejercicio> listarEjercicios() {
        return this.entidadesADTO(this.ejercicioRepository.findAll());
    }

    public Ejercicio buscarEjercicioPorNombre(String nombre) {
        EjercicioEntity ejercicio = this.ejercicioRepository.findByNombre(nombre);
        if (ejercicio != null) {
            return ejercicio.toDTO();
        } else {
            return null;
        }
    }
    public List<Ejercicio> buscarEjerciciosNoContenidosEnSesionPorTipo(Integer idSesion, String tipo) {
        return this.entidadesADTO(this.ejercicioRepository.findNotContainedInSesionByTipo(idSesion, tipo));
    }


    public void guardarEjercicio(Ejercicio ejercicio) {
        EjercicioEntity ejercicioEntity;
        if (ejercicio.getId() == null) {
            ejercicioEntity = new EjercicioEntity();
        } else {
            ejercicioEntity = ejercicioRepository.findById(ejercicio.getId()).orElse(new EjercicioEntity());
        }
        ejercicioEntity.setNombre(ejercicio.getNombre());
        ejercicioEntity.setIdtipo(tipoRepository.findById(ejercicio.getTipo().getId()).orElse(null));
        ejercicioEntity.setUrl(ejercicio.getUrl());
        ejercicioRepository.save(ejercicioEntity);
    }

    public Ejercicio buscarPorId(int id) {
        EjercicioEntity ejercicio = this.ejercicioRepository.findById(id).orElse(null);
        if (ejercicio != null) {
            return ejercicio.toDTO();
        } else {
            return null;
        }
    }

    public void borrarEjercicio(int id) {
        EjercicioEntity ejercicio = this.ejercicioRepository.findById(id).orElseThrow(() -> new NotFoundException("Ejercicio not found with id: " + id));
        List<EjercicioGrupomuscularEntity> ejerciciosGrupomuscular = ejercicioGrupomuscularRepository.findByRelatioshipsByEjercicioId(ejercicio.getId());
        if (!ejerciciosGrupomuscular.isEmpty()) {
            ejercicioGrupomuscularRepository.deleteAll(ejerciciosGrupomuscular);
        }

        this.ejercicioRepository.deleteById(id);
    }

    public List<Ejercicio> listarEjerciciosPorFiltro(FiltroEjercicio filtro) {
        List<EjercicioEntity> ejercicios = this.ejercicioRepository.findByFiltro(filtro);
        return this.entidadesADTO(ejercicios);
    }
}

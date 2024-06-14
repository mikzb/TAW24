package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 100%
 */


import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.EjercicioRepository;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService extends DTOService<Ejercicio, EjercicioEntity>{

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<Ejercicio> listarEjercicios() {
        return this.entidadesADTO(this.ejercicioRepository.findAll());
    }

    public List<Ejercicio> buscarEjerciciosPorTipo(String tipo) {
        return this.entidadesADTO(this.ejercicioRepository.buscarPorTipo(tipo));
    }

    public void guardarEjercicio(Ejercicio ejercicio) {
        EjercicioEntity ejercicioEntity = ejercicioRepository.findById(ejercicio.getId()).orElse(new EjercicioEntity());
        ejercicioEntity.setNombre(ejercicio.getNombre());
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
        this.ejercicioRepository.deleteById(id);
    }
}

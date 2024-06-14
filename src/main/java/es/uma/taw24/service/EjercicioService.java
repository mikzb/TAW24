package es.uma.taw24.service;

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
}

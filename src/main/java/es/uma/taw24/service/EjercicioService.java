package es.uma.taw24.service;

import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.Sesion;
import es.uma.taw24.DTO.Usuario;
import es.uma.taw24.dao.EjercicioRepository;
import es.uma.taw24.entity.EjercicioEntity;
import es.uma.taw24.entity.RutinaEntity;
import es.uma.taw24.entity.SesionEntity;
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

    public EjercicioEntity buscarEjercicioPorId(Integer id) {
        return this.ejercicioRepository.findByIdEjercicio(id);
    }
}

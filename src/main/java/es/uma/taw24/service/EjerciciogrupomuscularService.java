package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.EjercicioGrupomuscular;
import es.uma.taw24.DTO.EntrenadorUsuario;
import es.uma.taw24.DTO.GrupoMuscular;
import es.uma.taw24.dao.*;
import es.uma.taw24.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EjerciciogrupomuscularService extends DTOService<EjercicioGrupomuscular, EjercicioGrupomuscularEntity>{

    @Autowired
    private EjercicioGrupomuscularRepository ejercicioGrupomuscularRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private GrupoMuscularRepository grupomuscularRepository;

    @Transactional
    public void asignarEjercicioGrupo(EjercicioGrupomuscular ejercicioGrupomuscular) {
        EjercicioEntity ejercicioEntity = ejercicioRepository.findById(ejercicioGrupomuscular.getEjercicioId()).orElseThrow(() -> new IllegalArgumentException("Ejercicio no encontrado"));
        GrupomuscularEntity grupomuscularEntity = grupomuscularRepository.findById(ejercicioGrupomuscular.getGrupomuscularId()).orElseThrow(() -> new IllegalArgumentException("Grupo muscular no encontrado"));

        EjercicioGrupomuscularIdEntity id = new EjercicioGrupomuscularIdEntity();
        id.setIdejercicio(ejercicioEntity.getId());
        id.setIdgrupomuscular(grupomuscularEntity.getId());

        EjercicioGrupomuscularEntity newAssignment = new EjercicioGrupomuscularEntity();
        newAssignment.setId(id);
        newAssignment.setIdgrupomuscular(grupomuscularEntity);
        newAssignment.setIdejercicio(ejercicioEntity);

        ejercicioGrupomuscularRepository.save(newAssignment);
    }

    @Transactional
    public void desasignarEjercicioGrupo( int idEjercicio, int idGrupomuscular) {
        List<EjercicioGrupomuscularEntity> ejercicioGrupomuscularEntities = ejercicioGrupomuscularRepository.findByEjercicioIdAndGrupoMuscularId(idEjercicio, idGrupomuscular);
        if (!ejercicioGrupomuscularEntities.isEmpty()) {
            ejercicioGrupomuscularRepository.delete(ejercicioGrupomuscularEntities.getFirst());
        }
    }
}

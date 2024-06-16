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

import java.security.Guard;
import java.util.HashSet;
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
    public void asignarEjercicioGrupo(Integer ejercicioId, Integer grupoMuscularId) {
        EjercicioEntity ejercicio = ejercicioRepository.findById(ejercicioId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ejercicio ID:" + ejercicioId));
        GrupomuscularEntity grupoMuscular = grupomuscularRepository.findById(grupoMuscularId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid grupo muscular ID:" + grupoMuscularId));


        if (ejercicio.getGruposMusculares() == null) {
            ejercicio.setGruposMusculares(new HashSet<>());
        }

        if (ejercicio.getGruposMusculares().contains(grupoMuscular)) {
            throw new IllegalArgumentException("Ejercicio " + ejercicioId + " ya tiene asignado el grupo muscular " + grupoMuscularId);
        }


        ejercicio.getGruposMusculares().add(grupoMuscular);
        ejercicioRepository.save(ejercicio);
    }

    @Transactional
    public void desasignarEjercicioGrupo(Integer ejercicioId, Integer grupoMuscularId) {
        EjercicioEntity ejercicio = ejercicioRepository.findById(ejercicioId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ejercicio ID:" + ejercicioId));
        GrupomuscularEntity grupoMuscular = grupomuscularRepository.findById(grupoMuscularId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid grupo muscular ID:" + grupoMuscularId));

        if (ejercicio.getGruposMusculares() == null) {
            throw new IllegalArgumentException("Ejercicio " + ejercicioId + " no tiene asignado ningún grupo muscular");
        }

        if (!ejercicio.getGruposMusculares().contains(grupoMuscular)) {
            throw new IllegalArgumentException("Ejercicio " + ejercicioId + " no tiene asignado el grupo muscular " + grupoMuscularId);
        }


        ejercicio.getGruposMusculares().remove(grupoMuscular);
        ejercicioRepository.save(ejercicio);
    }
}

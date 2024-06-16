package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.GrupoMuscular;
import es.uma.taw24.dao.EjercicioGrupomuscularRepository;
import es.uma.taw24.dao.EjercicioRepository;
import es.uma.taw24.dao.GrupoMuscularRepository;
import es.uma.taw24.entity.GrupomuscularEntity;
import es.uma.taw24.exception.NotFoundException;
import es.uma.taw24.ui.FiltroGrupoMuscular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrupoMuscularService extends DTOService<GrupoMuscular, GrupomuscularEntity>{
    @Autowired
    private GrupoMuscularRepository grupomuscularRepository;
    @Autowired
    private EjercicioGrupomuscularRepository ejercicioGrupomuscularRepository;
    @Autowired
    private EjercicioRepository ejercicioRepository;

    public void guardarGrupoMuscular(GrupoMuscular grupoMuscular) {
        GrupomuscularEntity grupoMuscularEntity;
        if (grupoMuscular.getId() == null) {
            grupoMuscularEntity = new GrupomuscularEntity();
        } else {
            grupoMuscularEntity = grupomuscularRepository.findById(grupoMuscular.getId()).orElse(new GrupomuscularEntity());
        }
        grupoMuscularEntity.setNombre(grupoMuscular.getNombre());
        grupomuscularRepository.save(grupoMuscularEntity);
    }

    public boolean grupoMuscularExiste(int id) {
        return this.grupomuscularRepository.findById(id).isPresent();
    }

    @Transactional
    public void borrarGrupoMuscular(int id) throws NotFoundException {
        GrupomuscularEntity grupomuscular = grupomuscularRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("GrupoMuscular not found with id: " + id));

        grupomuscular.getEjercicios().forEach(ejercicio -> {
            ejercicio.getGruposMusculares().remove(grupomuscular);
            ejercicioRepository.save(ejercicio);
        });

        grupomuscularRepository.deleteById(id);
    }

    public List<GrupoMuscular> buscarGrupomuscularPorEjercicio(Integer idEjercicio) {
        return this.entidadesADTO(this.ejercicioGrupomuscularRepository.findByEjercicioId(idEjercicio));
    }

    public GrupoMuscular buscarPorId(int id) {
        GrupomuscularEntity grupoMuscular = this.grupomuscularRepository.findById(id).orElse(null);
        if (grupoMuscular != null) {
            return grupoMuscular.toDTO();
        } else {
            return null;
        }
    }

    public List<GrupoMuscular> listarGruposMusculares() {
        return this.entidadesADTO(this.grupomuscularRepository.findAll());
    }

    public List<GrupoMuscular> listarGruposMuscularesPorFiltro(FiltroGrupoMuscular filtro) {
        return this.entidadesADTO(this.grupomuscularRepository.findByFiltro(filtro.getNombre()));
    }
}

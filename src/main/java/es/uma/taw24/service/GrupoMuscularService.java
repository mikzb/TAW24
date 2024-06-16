package es.uma.taw24.service;

/**
 * @author Ignacy Borzestowski: 100%
 */

import es.uma.taw24.DTO.Ejercicio;
import es.uma.taw24.DTO.GrupoMuscular;
import es.uma.taw24.dao.EjercicioGrupomuscularRepository;
import es.uma.taw24.dao.GrupoMuscularRepository;
import es.uma.taw24.entity.GrupomuscularEntity;
import es.uma.taw24.ui.FiltroGrupoMuscular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoMuscularService extends DTOService<GrupoMuscular, GrupomuscularEntity>{
    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;
    @Autowired
    private EjercicioGrupomuscularRepository ejercicioGrupomuscularRepository;

    public void guardarGrupoMuscular(GrupoMuscular grupoMuscular) {
        GrupomuscularEntity grupoMuscularEntity;
        if (grupoMuscular.getId() == null) {
            grupoMuscularEntity = new GrupomuscularEntity();
        } else {
            grupoMuscularEntity = grupoMuscularRepository.findById(grupoMuscular.getId()).orElse(new GrupomuscularEntity());
        }
        grupoMuscularEntity.setNombre(grupoMuscular.getNombre());
        grupoMuscularRepository.save(grupoMuscularEntity);
    }

    public boolean grupoMuscularExiste(int id) {
        return this.grupoMuscularRepository.findById(id).isPresent();
    }

    public void borrarGrupoMuscular(int id) {
        this.grupoMuscularRepository.deleteById(id);
    }

    public List<GrupoMuscular> buscarGrupomuscularPorEjercicio(Integer idEjercicio) {
        return this.entidadesADTO(this.ejercicioGrupomuscularRepository.findByEjercicioId(idEjercicio));
    }

    public GrupoMuscular buscarPorId(int id) {
        GrupomuscularEntity grupoMuscular = this.grupoMuscularRepository.findById(id).orElse(null);
        if (grupoMuscular != null) {
            return grupoMuscular.toDTO();
        } else {
            return null;
        }
    }

    public List<GrupoMuscular> listarGruposMusculares() {
        return this.entidadesADTO(this.grupoMuscularRepository.findAll());
    }

    public List<GrupoMuscular> listarGruposMuscularesPorFiltro(FiltroGrupoMuscular filtro) {
        return this.entidadesADTO(this.grupoMuscularRepository.findByFiltro(filtro.getNombre()));
    }
}

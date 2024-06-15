/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.service;

import es.uma.taw24.DTO.*;
import es.uma.taw24.dao.*;
import es.uma.taw24.entity.*;
import es.uma.taw24.exception.ExistingDietaException;
import es.uma.taw24.exception.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DietaService extends DTOService<Dieta, DietaEntity>{

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private DietaDiaRepository dietaDiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDietaRepository usuarioDietaRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private MenuDiaRepository menuDiaRepository;

    @Autowired
    private DiaRepository diaRepository;

    @Autowired
    private ComidaMenuRepository comidaMenuRepository;

    public Dieta buscarPorDietaId(Integer dietaId) {
        DietaEntity dieta = this.dietaRepository.findById(dietaId).orElse(null);
        Dieta dietaDTO = new Dieta();

        dietaDTO.setId(dieta.getId());
        dietaDTO.setFechaCreacion(dieta.getFechacreacion());
        dietaDTO.setDescripcion(dieta.getDescripcion());

        return dietaDTO;
    }

    public Dieta buscarDietaPorUsuarioId(Integer usuarioId) {
        DietaEntity dieta = this.usuarioRepository.findDietaByUsuarioId(usuarioId);
        Dieta dietaDTO = new Dieta();

        dietaDTO.setId(dieta.getId());
        dietaDTO.setFechaCreacion(dieta.getFechacreacion());
        dietaDTO.setDescripcion(dieta.getDescripcion());

        return dietaDTO;
    }

    public List<Dieta> listarDietasDietista(Integer dietistaId) {
        List<DietaEntity> dietas = this.dietaRepository.findByDietistaId(dietistaId);

        List<Dieta> dietasDTO = new ArrayList<>();
        for (DietaEntity dieta : dietas) {
            Dieta dietaDTO = new Dieta();
            dietaDTO.setId(dieta.getId());
            dietaDTO.setFechaCreacion(dieta.getFechacreacion());
            dietaDTO.setDescripcion(dieta.getDescripcion());
            dietasDTO.add(dietaDTO);
        }

        return dietasDTO;
    }

    public List<Dieta> listarDietasDietistaPorDescripcion(Integer dietistaId, String descripcion) {
        List<DietaEntity> dietas = this.dietaRepository.findByDietistaIdAndDescripcion(dietistaId, descripcion);

        List<Dieta> dietasDTO = new ArrayList<>();
        for (DietaEntity dieta : dietas) {
            Dieta dietaDTO = new Dieta();
            dietaDTO.setId(dieta.getId());
            dietaDTO.setFechaCreacion(dieta.getFechacreacion());
            dietaDTO.setDescripcion(dieta.getDescripcion());
            dietasDTO.add(dietaDTO);
        }

        return dietasDTO;
    }

    public Dieta cargarDietaPorDietaId(Integer dietaId) {

        Dieta dieta = this.buscarPorDietaId(dietaId);

        List<Dia> dias = this.buscarDiasPorDietaId(dietaId);
        dieta.setDias(dias);

        for (Dia dia : dias) {
            Menu menu = this.buscarMenuPorDiaId(dia.getId());
            dia.setMenu(menu);

            List<Comida> comidas = this.buscarComidasPorMenuId(menu.getId());
            menu.setComidas(comidas);
        }

        return dieta;
    }

    public List<Dia> buscarDiasPorDietaId(Integer dietaId) {
        List<DiaEntity> dietaDias = this.diaRepository.findDiasByDietaId(dietaId);
        List<Dia> dias = new ArrayList<>();
        for (DiaEntity dia : dietaDias) {
            Dia diaDTO = new Dia();
            diaDTO.setId(dia.getId());
            diaDTO.setFecha(dia.getFecha());
            dias.add(diaDTO);
        }

        return dias;
    }

    public Menu buscarMenuPorDiaId(Integer diaId) {
        MenuEntity menu = this.menuRepository.findMenuByDiaId(diaId);
        Menu menuDTO = new Menu();
        menuDTO.setId(menu.getId());
        return menuDTO;
    }

    public List<Comida> buscarComidasPorMenuId(Integer menuId) {
        List<ComidaEntity> comidasMenu = this.comidaRepository.findComidasByMenuId(menuId);
        List<Comida> comidas = new ArrayList<>();

        int i = 1;
        for (ComidaEntity comida : comidasMenu) {
            Comida comidaDTO = new Comida();
            comidaDTO.setId(comida.getId());
            comidaDTO.setDescripcion(comida.getDescripcion());
            comidaDTO.setNumero(i);
            comidas.add(comidaDTO);
            i++;
        }

        return comidas;
    }

    public void borrarDieta(Integer dietaId) {
        this.borrarDiasDieta(dietaId);
        this.borrarUsuariosDieta(dietaId);
        this.dietaRepository.deleteById(dietaId);
    }

    public void borrarDiasDieta(Integer dietaId) {
        List<DietaDiaEntity> dietaDias = this.dietaDiaRepository.findByDietaId(dietaId);
        this.dietaDiaRepository.deleteAll(dietaDias);
    }

    public void borrarUsuariosDieta(Integer dietaId) {
        List<UsuarioDietaEntity> usuariosDieta = this.usuarioDietaRepository.findByDietaId(dietaId);
        this.usuarioDietaRepository.deleteAll(usuariosDieta);
    }

    public void actualizarUsuarioDieta(Integer usuarioId, Integer dietaId) {
        DietaEntity dieta = this.dietaRepository.findById(dietaId).orElse(null);
        this.usuarioDietaRepository.updateDieta(usuarioId, dieta);
    }

    public void guardarDietaCreada(Dieta dieta, Integer dietistaID) {
        Optional<DietaEntity> existingDieta = this.dietaRepository.findByDescripcion(dieta.getDescripcion());
        DietaEntity dietaEntity;
        if (existingDieta.isPresent()) {
            throw new ExistingDietaException("La dieta con descripción " +
                    existingDieta.get().getDescripcion() + " ya existe");
        } else {
            dietaEntity = new DietaEntity();
            dietaEntity.setFechacreacion(Instant.now());
            dietaEntity.setDescripcion(dieta.getDescripcion());
            UsuarioEntity dietista = this.usuarioRepository.findById(dietistaID).orElse(null);
            dietaEntity.setIddietista(dietista);
            this.dietaRepository.save(dietaEntity);
        }

        for (int i = 0; i < dieta.getDias().size(); i++) {
            DiaEntity dia = new DiaEntity();
            dia.setFecha(Instant.now().plus(Duration.ofDays(i)));
            this.diaRepository.save(dia);

            DietaDiaEntity dietaDiaEntity = new DietaDiaEntity();
            dietaDiaEntity.setDieta(dietaEntity);
            dietaDiaEntity.setDia(dia);
            this.dietaDiaRepository.save(dietaDiaEntity);

            MenuEntity menuEntity = new MenuEntity();
            this.menuRepository.save(menuEntity);

            MenuDiaEntity menuDiaEntity = new MenuDiaEntity();
            menuDiaEntity.setMenu(menuEntity);
            menuDiaEntity.setDia(dia);
            this.menuDiaRepository.save(menuDiaEntity);

            for (int j = 0; j < dieta.getDias().get(i).getMenu().getComidas().size(); j++) {
                ComidaEntity comida = this.comidaRepository.findById(dieta.getDias().get(i).getMenu().getComidas().get(j).getId()).orElse(null);

                ComidaMenuEntity comidaMenuEntity = new ComidaMenuEntity();
                comidaMenuEntity.setMenu(menuEntity);
                comidaMenuEntity.setComida(comida);
                comidaMenuEntity.setNumero(j+1);
                this.comidaMenuRepository.save(comidaMenuEntity);
            }
        }
    }

    public void actualizarDescripcionDieta(Integer dietaId, String descripcion) {
        this.dietaRepository.update(dietaId, descripcion);
    }

    public void actualizarComida(Integer menuId, Integer comidaActualId, Integer comidaNuevaId) {
        ComidaEntity comidaNueva = this.comidaRepository.findById(comidaNuevaId).orElse(null);
        this.comidaMenuRepository.update(menuId, comidaActualId, comidaNueva);
    }
}

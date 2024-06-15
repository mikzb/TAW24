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
    private ComidaMenuRepository comidaMenuRepository;

    @Autowired
    private MenuDiaRepository menuDiaRepository;

    @Autowired
    private DiaRepository diaRepository;

    public Dieta buscarPorDietaId(Integer dietaId) {
        DietaEntity dieta = this.dietaRepository.findById(dietaId).orElse(null);
        Dieta dietaDTO = new Dieta();

        dietaDTO.setId(dieta.getId());
        dietaDTO.setFechaCreacion(dieta.getFechacreacion());
        dietaDTO.setDescripcion(dieta.getDescripcion());

        return dietaDTO;
    }

    public Dieta buscarComidasPorDietaId(Integer dietaId) {

        List<ComidaEntity> comidas = this.dietaRepository.findComidasByDietaId(dietaId);
        List<Comida> comidasDTO = new ArrayList<>();

        for (ComidaEntity comida : comidas) {
            Comida comidaDTO = new Comida();

            comidaDTO.setId(comida.getId());
            comidaDTO.setDescripcion(comida.getDescripcion());

            comidasDTO.add(comidaDTO);
        }

        DietaEntity dieta = this.dietaRepository.findById(dietaId).orElse(null);
        Dieta dietaDTO = new Dieta();
        List<Dia> dias = new ArrayList<>();
        dietaDTO.setDias(dias);

        dietaDTO.setId(dieta.getId());
        dietaDTO.setFechaCreacion(dieta.getFechacreacion());
        dietaDTO.setDescripcion(dieta.getDescripcion());

        for (int i = 0; i < 5; i++) {
            Menu menu = new Menu();
            List<Comida> comidasMenu = new ArrayList<>();

            for (int j = 0; j < 7; j++) {
                comidasMenu.add(comidasDTO.get(i * 7 + j));
            }

            menu.setComidas(comidasMenu);
            Dia dia = new Dia();
            dia.setMenu(menu);
            dietaDTO.getDias().add(dia);
        }

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

    public Dieta buscarDietaPorUsuarioId(Integer usuarioId) {
        DietaEntity dieta = this.usuarioRepository.findDietaByUsuarioId(usuarioId);
        Dieta dietaDTO = new Dieta();

        dietaDTO.setId(dieta.getId());
        dietaDTO.setFechaCreacion(dieta.getFechacreacion());
        dietaDTO.setDescripcion(dieta.getDescripcion());

        return dietaDTO;
    }

    public void guardarDietaCreada(Dieta dieta, Integer dietistaID) {
        // Comprobar si la dieta ya existe, usando algún criterio para determinar la unicidad
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
            LocalDate currentDate = LocalDate.now();
            LocalDate newDate = currentDate.plusDays(i);
            Instant instantDate = newDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
            dia.setFecha(instantDate);

            Optional<DiaEntity> existingDia = this.diaRepository.findByFecha(dia.getFecha());
            if (existingDia.isPresent()) {
                dia = existingDia.get();
            } else {
                this.diaRepository.save(dia);
            }

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
                this.comidaMenuRepository.save(comidaMenuEntity);
            }
        }
    }

    public void actualizarDescripcionDieta(Integer dietaId, String descripcion) {
    }

    public void actualizarComida(Integer actualId, Integer nuevoId, Integer dia, Integer comida) {
    }
}

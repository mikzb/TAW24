package es.uma.taw24.dao;

import es.uma.taw24.entity.UsuarioEntity;
import es.uma.taw24.ui.FiltroUsuario;

import java.util.List;

public interface UsuarioRepositoryCustom {
    List<UsuarioEntity> findByFiltro(FiltroUsuario filtro);
}

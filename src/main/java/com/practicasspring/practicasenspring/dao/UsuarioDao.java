package com.practicasspring.practicasenspring.dao;

import com.practicasspring.practicasenspring.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminarUsuario(long id);

    void registrarUsuario(Usuario usuario);
}

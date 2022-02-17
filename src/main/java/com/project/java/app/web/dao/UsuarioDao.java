package com.project.java.app.web.dao;

import com.project.java.app.web.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();


    void eliminar(Long id);

    void registrar(Usuario usuario);


    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}

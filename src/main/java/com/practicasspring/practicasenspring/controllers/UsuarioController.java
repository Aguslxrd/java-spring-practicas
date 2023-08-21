package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.dao.UsuarioDao;
import com.practicasspring.practicasenspring.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao; //inyeccion de dependencia


    @RequestMapping(value = "api/v1/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setNombre("damian");
        usuario.setApellido("suffo");
        usuario.setEmail("suffodamian02@gmail.com");
        usuario.setTelefono("232323");
        usuario.setPasswd("123456789");
        usuario.setId(14);
        return usuario;
    }

    @RequestMapping(value = "api/v1/usuarios", method = RequestMethod.GET )
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/v1/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable long id){
        usuarioDao.eliminarUsuario(id);
    }
}

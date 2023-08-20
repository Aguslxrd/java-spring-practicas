package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("damian");
        usuario.setApellido("suffo");
        usuario.setEmail("suffodamian02@gmail.com");
        usuario.setTelefono("232323");
        usuario.setPassword("123456789");
        return usuario;
    }
}

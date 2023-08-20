package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setNombre("damian");
        usuario.setApellido("suffo");
        usuario.setEmail("suffodamian02@gmail.com");
        usuario.setTelefono("232323");
        usuario.setPassword("123456789");
        usuario.setId(14);
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        Usuario usuario = new Usuario();
        List<Usuario>usuarios = new ArrayList<>();
        usuario.setNombre("damian");
        usuario.setApellido("suffo");
        usuario.setEmail("suffodamian02@gmail.com");
        usuario.setTelefono("232323");
        usuario.setPassword("123456789");
        usuario.setId(14l);
        //
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("agustin");
        usuario2.setApellido("perez");
        usuario2.setEmail("perezasgsa@gmail.com");
        usuario2.setTelefono("1232135");
        usuario2.setPassword("35334");
        usuario2.setId(11l);
        //
        Usuario usuario3 = new Usuario();
        usuario3.setNombre("jorge");
        usuario3.setApellido("perez");
        usuario3.setEmail("jgperz@gmail.com");
        usuario3.setTelefono("456564");
        usuario3.setPassword("13463434");
        usuario3.setId(10l);
        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
    }

}

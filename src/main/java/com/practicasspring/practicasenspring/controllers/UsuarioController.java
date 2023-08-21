package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.dao.UsuarioDao;
import com.practicasspring.practicasenspring.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        usuarioDao.eliminarUsuario(id); //implementar logica para checkear si existe o no un usuario, lo mismo en GET
    }

    private boolean isValidUsuario(Usuario usuario) {
        return usuario.getNombre() != null &&
                usuario.getApellido() != null &&
                usuario.getEmail() != null &&
                usuario.getPasswd() != null;
    }
    @RequestMapping(value = "api/v1/usuarios", method = RequestMethod.POST)
    public ResponseEntity<Object> registrarUsuarios(@RequestBody(required = false) Usuario usuario) {
        if (usuario == null || !isValidUsuario(usuario)) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "El cuerpo de la petición está vacío o el formato del usuario es incompleto.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
        String springArgon2Hash = arg2SpringSecurity.encode(usuario.getPasswd());//agregar excepciones
        assert(arg2SpringSecurity.matches(usuario.getPasswd(), springArgon2Hash));
        usuario.setPasswd(springArgon2Hash);

        usuarioDao.registrarUsuario(usuario);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}

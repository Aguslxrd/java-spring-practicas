package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.dao.UsuarioDao;
import com.practicasspring.practicasenspring.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/v1/login", method = RequestMethod.POST) //Devolver estados http
    public String login(@RequestBody Usuario usuario) {
        if (usuarioDao.verificarCredenciales(usuario)){
            return "Ok";
        }else {
            return "Failed";
        }
    }
}

package com.practicasspring.practicasenspring.controllers;

import com.practicasspring.practicasenspring.dao.UsuarioDao;
import com.practicasspring.practicasenspring.models.Usuario;
import com.practicasspring.practicasenspring.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    //inyeccion de dependencias
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/v1/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {
        Usuario userJwtLoggeado = usuarioDao.verificarCredenciales(usuario);
        if (userJwtLoggeado != null) {
            String jwtToken = jwtUtil.create(String.valueOf(userJwtLoggeado.getId()), userJwtLoggeado.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}

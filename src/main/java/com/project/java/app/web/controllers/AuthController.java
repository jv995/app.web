package com.project.java.app.web.controllers;


import com.project.java.app.web.dao.UsuarioDao;
import com.project.java.app.web.models.Usuario;
import com.project.java.app.web.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtils jwtUtils;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
       if(usuarioLogueado != null){

         String tokenJwt = jwtUtils.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
         return tokenJwt;
       }
            return "FAIL";
    }
}

package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Optional;
@RestController
public class TokenController {
    @Autowired
    UsuarioServiceImplement usuarioServiceImplement;

    @GetMapping("/tkn/{token}")
    public String getTokenExp(@PathVariable String token) {
        HashMap<String, String> map = new HashMap<>();
        boolean rest = SecurityBussines.chekTockenExp(token);
        if(rest){
            map.put(Messages.MSG, Messages.TOKEN+" valido");
        }else {
            map.put(Messages.MSG, Messages.TOKEN+ "expirado");
        }
        return new Gson().toJson(map);
    }
    @PostMapping("/tkn/{token}")
    public String refresh(@PathVariable String token) {
        HashMap<String, String> map = new HashMap<>();
        if (SecurityBussines.chekTockenExp(token)) {
            String email = SecurityBussines.getTockenUsr(token);
            Optional<Usuario> op = usuarioServiceImplement.findFirstByEmailLike(email);
            map.put(Messages.TOKEN, SecurityBussines.getJWTToken(SecurityBussines.getTockenUsr(token), op.isPresent()? op.get() : null));
            return new Gson().toJson(map);
        } else {
            map.put(Messages.MSG, Messages.TOKEN+" expirado");
            return new Gson().toJson(map);
        }
    }

}

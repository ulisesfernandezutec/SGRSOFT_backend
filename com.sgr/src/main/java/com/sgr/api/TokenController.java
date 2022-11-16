package com.sgr.api;

import com.google.gson.Gson;
import com.sgr.bussines.Messages;
import com.sgr.bussines.Utils;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.bussines.security.SecurityGoogleTokenVerifier;
import com.sgr.entities.APOD;
import com.sgr.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RestController
public class TokenController {
    @Autowired
    UsuarioServiceImplement usuarioServiceImplement;

    @GetMapping("/tkn/{token}")
    public String getTokenExp(@PathVariable String token) {
        HashMap<String, String> map = new HashMap<>();
        if(SecurityBussines.chekTockenExp(token)){
            map.put(Messages.msg, Messages.token+" valido");
        }else {
            map.put(Messages.msg, Messages.token+ "expirado");
        }
        return new Gson().toJson(map);
    }

    @PostMapping("/tkn/{token}")
    public String refresh(@PathVariable String token) {
        HashMap<String, String> map = new HashMap<>();
        if (SecurityBussines.chekTockenExp(token)) {
            String email = SecurityBussines.getTockenUsr(token);
            map.put(Messages.token, SecurityBussines.getJWTToken(SecurityBussines.getTockenUsr(token), usuarioServiceImplement.findFirstByEmailLike(email).get()));
            return new Gson().toJson(map);
        } else {
            map.put(Messages.msg, Messages.token+" expirado");
            return new Gson().toJson(map);
        }
    }

}

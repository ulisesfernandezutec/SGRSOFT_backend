package com.sgr.api.controllers;

import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
@RestController
public class ConfirmController {
    @Autowired
    UsuarioServiceImplement usuarioServiceImplement;
    @GetMapping("/login/newuserok/")
    public String toConfirm(@RequestParam("uuid") UUID uuid) {
        Optional<Usuario> usr = usuarioServiceImplement.findFirstByEstadoLike(uuid.toString());
        if(usr.isPresent()){
            Usuario usuario;
            usuario = usr.get();
            usuario.setEstado("Activo");
            usuario.setDireccion("Direccion editada");
            usuarioServiceImplement.update(usuario);
        }
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "\n" +
                "    <title>Usuario confirmado</title>\n" +
                "    <style>\n" +
                "        #cont{\n" +
                "        width: 80%;\n" +
                "        margin: auto;\n" +
                "        height: 500px;\n" +
                "        height: 500px;\n" +
                "        margin: auto;\n" +
                "        width: 50%;\n" +
                "        padding: 10px;\n" +
                "        background-color: #ffffff;\n" +
                "        text-align: center;\n" +
                "        }\n" +
                "        body{\n" +
                "           background-color: #56b509;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "<body>\n" +
                "<div id=\"cont\">\n" +
                "<img src=\"https://drive.google.com/uc?export=view&id=1ujiDHZmex58gLuxtDnhWOkS6zqAeEy3x\" alt=\"logo\">\n" +
                "<h3>Usuario cofirmado</h3>\n" +
                "<h4>Puede cerrar esta página</h4>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}

package com.sgr.api.controllers.metrics;

import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class UserMetrics {
    @Autowired
    UsuarioServiceImplement usuarioServiceImplement;
    @GetMapping("/metrics/usuarios")
    public String allArticles(Model model) {
        List<Usuario> lista = usuarioServiceImplement.list();
        Usuario p = lista.get(0);
        Usuario l = lista.get(lista.size()-1);
        model.addAttribute("usuarios", lista);
        model.addAttribute("cantidad", lista.size());
        model.addAttribute("primerreg",new Date(p.get_id()));
        model.addAttribute("ultimoreg",new Date(l.get_id()));
        return "metrics/usuarios-list";
    }
}

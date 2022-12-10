package com.sgr.api.controllers.metrics;

import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.bussines.Utils;
import com.sgr.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserMetrics {
    @Autowired
    UsuarioServiceImplement usuarioServiceImplement;
    @GetMapping("/metrics/usuarios")
    public String allArticles(Model model) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        List<Usuario> lista = usuarioServiceImplement.list();
        long p = lista.stream().mapToLong(x -> x.get_id()).min().getAsLong();
        long l = lista.stream().mapToLong(x -> x.get_id()).max().getAsLong();
        model.addAttribute("usuarios", lista);
        model.addAttribute("cantidad", lista.size());
        model.addAttribute("primerreg",sd.format(new Date(p)));
        model.addAttribute("ultimoreg",sd.format(new Date(l)));
        model.addAttribute("mesesusuarios",Utils.filtrarMeses(lista));
        //model.addAttribute("aniosusuarios",Utils.filtrarAnios(lista));
        return "metrics/usuarios-list";
    }
}

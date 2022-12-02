package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaPuntoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.RutaPunto;
import com.sgr.entities.dto.RutaPuntoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RutaPuntoController {
    @Autowired
    RutaPuntoServiceImplement rutaPuntoServiceImplement;

    // getall
    @GetMapping("/rp")
    public List<RutaPunto> getAll() {
        return rutaPuntoServiceImplement.list();
    }
    // getone
    @GetMapping("/rp/{id}")
    public RutaPunto getRutaPunto(@PathVariable("id") String id) {
        return rutaPuntoServiceImplement.getById(Long.parseLong(id));
    }
    // setone
    @PostMapping("/rp")
    public String setRutaPunto(@RequestBody RutaPuntoDTO rutaPuntoDTO) {
        RutaPunto rutaPunto = new RutaPunto();
        rutaPunto.set_id(rutaPuntoDTO.get_id());
        rutaPunto.setGoogleDuration(rutaPuntoDTO.getGoogleDuration());
        rutaPunto.setGoogleDistance(rutaPuntoDTO.getGoogleDistance());
        rutaPunto.setEstado(rutaPunto.getEstado());
        rutaPunto.setPunto(rutaPunto.getPunto());
        try {
            Long id = 0L;
            rutaPunto.set_id(id);
            rutaPuntoServiceImplement.create(rutaPunto);
            return new Gson().fromJson(Messages.RT_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // update
    @PutMapping("/rp")
    public boolean updateRutaPunto(@RequestBody RutaPuntoDTO rutaPuntoDTO) {
        RutaPunto rutaPunto = new RutaPunto();
        rutaPunto.set_id(rutaPuntoDTO.get_id());
        rutaPunto.setGoogleDuration(rutaPuntoDTO.getGoogleDuration());
        rutaPunto.setGoogleDistance(rutaPuntoDTO.getGoogleDistance());
        rutaPunto.setEstado(rutaPunto.getEstado());
        rutaPunto.setPunto(rutaPunto.getPunto());
        try {
            if (rutaPuntoServiceImplement.getById(rutaPunto.get_id()) != null) {
                rutaPuntoServiceImplement.update(rutaPunto);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    // delete
    @DeleteMapping("/rp/{id}")
    public String deleteRutaPunto(@PathVariable Long id) {
        try {
            rutaPuntoServiceImplement.delete(id);
            return Messages.RP_ELIMINADO;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

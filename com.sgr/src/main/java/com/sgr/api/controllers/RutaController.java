package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.Ruta;
import com.sgr.entities.RutaPunto;
import com.sgr.entities.dto.RutaDTO;
import com.sgr.entities.dto.RutaPuntoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RutaController {
    @Autowired
    RutaServiceImplement rutaServiceImplement;
    // getall
    @GetMapping("/ruta")
    public List<Ruta> getAll() {
        return rutaServiceImplement.list();
    }
    // getone
    @GetMapping("/ruta/{id}")
    public Ruta getRutaPunto(@PathVariable("id") String id) {
        return rutaServiceImplement.getById(Long.parseLong(id));
    }
    // setone
    @PostMapping("/ruta")
    public String setRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = new Ruta();
        ruta.set_id(rutaDTO.get_id());
        ruta.setVehiculo(rutaDTO.getVehiculo());
        ruta.setAdministrador(rutaDTO.getAdministrador());
        ruta.setPuntos(rutaDTO.getPuntos());
        ruta.setNombre(rutaDTO.getNombre());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setBound(rutaDTO.getBound());
        try {
            Long id = 0L;
            ruta.set_id(id);
            rutaServiceImplement.create(ruta);
            return new Gson().fromJson(Messages.RT_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // update
    @PutMapping("/ruta")
    public boolean updateRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = new Ruta();
        ruta.set_id(rutaDTO.get_id());
        ruta.setVehiculo(rutaDTO.getVehiculo());
        ruta.setAdministrador(rutaDTO.getAdministrador());
        ruta.setPuntos(rutaDTO.getPuntos());
        ruta.setNombre(rutaDTO.getNombre());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setBound(rutaDTO.getBound());
        try {
            if (rutaServiceImplement.getById(ruta.get_id()) != null) {
                rutaServiceImplement.update(ruta);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    // delete
    @DeleteMapping("/ruta/{id}")
    public String deleteRuta(@PathVariable Long id) {
        try {
            rutaServiceImplement.delete(id);
            return Messages.RT_ELIMINADO;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

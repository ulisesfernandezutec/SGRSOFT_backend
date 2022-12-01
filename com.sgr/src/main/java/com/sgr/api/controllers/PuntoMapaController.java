package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.PuntoMapaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoMapa;
import com.sgr.entities.dto.PuntoMapaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PuntoMapaController {

    @Autowired
    PuntoMapaServiceImplement puntoMapaServiceImplement;

    // getall
    @GetMapping("/pmapa")
    public List<PuntoMapa> getAll() {
        return puntoMapaServiceImplement.list();
    }

    // getone
    @GetMapping("/pmapa/{id}")
    public PuntoMapa getPuntoDisposicionFinal(@PathVariable("id") String id) {
        return puntoMapaServiceImplement.getById(Long.parseLong(id));
    }

    // setone
    @PostMapping("/pmapa")
    public String setPuntoMapa(@RequestBody PuntoMapaDTO puntoMapaDTO) {
        PuntoMapa puntoMapa = new PuntoMapa();
        puntoMapa.set_id(puntoMapaDTO.getId());
        puntoMapa.setLongitud(puntoMapaDTO.getLongitud());
        puntoMapa.setLongitud(puntoMapaDTO.getLatitud());
        puntoMapa.setDireccion(puntoMapaDTO.getDireccion());
        puntoMapa.setDescripcion(puntoMapaDTO.getDescripcion());
        try {
            Long id = 0L;
            puntoMapa.set_id(id);
            puntoMapaServiceImplement.create(puntoMapa);
            return new Gson().fromJson(Messages.PNT_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // update
    @PutMapping("/pmapa")
    public boolean updatePuntoMapa(@RequestBody PuntoMapaDTO puntoMapalDTO) {
        PuntoMapa puntoMapa = new PuntoMapa();
        puntoMapa.set_id(puntoMapalDTO.getId());
        puntoMapa.setLongitud(puntoMapalDTO.getLongitud());
        puntoMapa.setLongitud(puntoMapalDTO.getLatitud());
        puntoMapa.setDireccion(puntoMapalDTO.getDireccion());
        puntoMapa.setDescripcion(puntoMapalDTO.getDescripcion());
        try {
            if (puntoMapaServiceImplement.getById(puntoMapa.get_id()) != null) {
                puntoMapaServiceImplement.update(puntoMapa);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    // delete
    @DeleteMapping("/pmapa/{id}")
    public String deletePuntoDisposicionFinal(@PathVariable Long id) {
        try {
            puntoMapaServiceImplement.delete(id);
            return Messages.PNT_ELIMINADO;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

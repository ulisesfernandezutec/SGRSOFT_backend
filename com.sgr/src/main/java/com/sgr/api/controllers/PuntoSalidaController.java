package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.PuntoSalidaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoSalida;
import com.sgr.entities.dto.PuntoSalidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PuntoSalidaController {

    @Autowired
    PuntoSalidaServiceImplement puntoSalidaServiceImplement;

    // getall
    @GetMapping("/psalida")
    public List<PuntoSalida> getAll() {
        return puntoSalidaServiceImplement.list();
    }

    // getone
    @GetMapping("/psalida/{id}")
    public PuntoSalida getPuntoSalida(@PathVariable("id") String id) {
        return puntoSalidaServiceImplement.getById(Long.parseLong(id));
    }
    // setone
    @PostMapping("/psalida")
    public String setPuntoSalida(@RequestBody PuntoSalidaDTO puntoSalidaDTO) {
        PuntoSalida puntoSalida = new PuntoSalida();
        puntoSalida.set_id(puntoSalidaDTO.get_id());
        puntoSalida.setLongitud(puntoSalidaDTO.getLongitud());
        puntoSalida.setLongitud(puntoSalidaDTO.getLatitud());
        puntoSalida.setDireccion(puntoSalidaDTO.getDireccion());
        puntoSalida.setDescripcion(puntoSalidaDTO.getDescripcion());
        try {
            Long id = 0L;
            puntoSalida.set_id(id);
            puntoSalidaServiceImplement.create(puntoSalida);
            return new Gson().fromJson(Messages.PNS_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // update
    @PutMapping("/psalida")
    public boolean updatePuntoSalida(@RequestBody PuntoSalidaDTO puntoSalidaDTODTO) {
        PuntoSalida puntoSalida = new PuntoSalida();
        puntoSalida.set_id(puntoSalidaDTODTO.get_id());
        puntoSalida.setLongitud(puntoSalidaDTODTO.getLongitud());
        puntoSalida.setLongitud(puntoSalidaDTODTO.getLatitud());
        puntoSalida.setDireccion(puntoSalidaDTODTO.getDireccion());
        puntoSalida.setDescripcion(puntoSalidaDTODTO.getDescripcion());
        try {
            if (puntoSalidaServiceImplement.getById(puntoSalida.get_id()) != null) {
                puntoSalidaServiceImplement.update(puntoSalida);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    // delete
    @DeleteMapping("/psalida/{id}")
    public String deletePuntoSalida(@PathVariable Long id) {
        try {
            puntoSalidaServiceImplement.delete(id);
            return Messages.PNS_ELIMINADO;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

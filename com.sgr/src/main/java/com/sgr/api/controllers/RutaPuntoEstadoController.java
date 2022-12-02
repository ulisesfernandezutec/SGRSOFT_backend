package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaPuntoEstadoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.RutaPuntoEstado;
import com.sgr.entities.dto.RutaPuntoEstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RutaPuntoEstadoController {
    @Autowired
    RutaPuntoEstadoServiceImplement rutaPuntoEstadoServiceImplement;

    // getall
    @GetMapping("/rpe")
    public List<RutaPuntoEstado> getAll() {
        return rutaPuntoEstadoServiceImplement.list();
    }

    // getone
    @GetMapping("/rpe/{id}")
    public RutaPuntoEstado getRutaPuntoEstado(@PathVariable("id") String id) {
        return rutaPuntoEstadoServiceImplement.getById(Long.parseLong(id));
    }
    // setone
    @PostMapping("/rpe")
    public String setRutaPuntoEstado(@RequestBody RutaPuntoEstadoDTO rutaPuntoEstadoDTO) {
        RutaPuntoEstado rutaPuntoEstado = new RutaPuntoEstado();
        rutaPuntoEstado.set_id(rutaPuntoEstadoDTO.get_id());
        rutaPuntoEstado.setNombre(rutaPuntoEstadoDTO.getNombre());
        rutaPuntoEstado.setDescripcion(rutaPuntoEstado.getDescripcion());
        try {
            Long id = 0L;
            rutaPuntoEstado.set_id(id);
            rutaPuntoEstadoServiceImplement.create(rutaPuntoEstado);
            return new Gson().fromJson(Messages.RPE_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // update
    @PutMapping("/rpe")
    public boolean updateRutaPuntoEstado(@RequestBody RutaPuntoEstadoDTO rutaPuntoEstadoDTO) {
        RutaPuntoEstado rutaPuntoEstado = new RutaPuntoEstado();
        rutaPuntoEstado.set_id(rutaPuntoEstadoDTO.get_id());
        rutaPuntoEstado.setNombre(rutaPuntoEstadoDTO.getNombre());
        rutaPuntoEstado.setDescripcion(rutaPuntoEstado.getDescripcion());
        try {
            if (rutaPuntoEstadoServiceImplement.getById(rutaPuntoEstado.get_id()) != null) {
                rutaPuntoEstadoServiceImplement.update(rutaPuntoEstado);
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    // delete
    @DeleteMapping("/rpe/{id}")
    public String deleteRutaPuntoEstado(@PathVariable Long id) {
        try {
            rutaPuntoEstadoServiceImplement.delete(id);
            return Messages.RPE_ELIMINADO;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

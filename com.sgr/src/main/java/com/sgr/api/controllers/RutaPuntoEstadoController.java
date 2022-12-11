package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaPuntoEstadoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.RutaPuntoEstado;
import com.sgr.entities.dto.RutaPuntoEstadoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RestController
public class RutaPuntoEstadoController {
    @Autowired
    RutaPuntoEstadoServiceImplement rutaPuntoEstadoServiceImplement;

    // getall
    @GetMapping("/rpe")
    public List<RutaPuntoEstado> getAll() {
        try {
            return rutaPuntoEstadoServiceImplement.list();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.RUTAPE);
        }
    }

    // getone
    @GetMapping("/rpe/{id}")
    public RutaPuntoEstado getRutaPuntoEstado(@PathVariable("id") String id) {
        try {
            return rutaPuntoEstadoServiceImplement.getById(Long.parseLong(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.RUTAPE);
        }
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.RUTAPE);
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR + Messages.RUTAPE);
        }
    }
    // delete
    @DeleteMapping("/rpe/{id}")
    public String deleteRutaPuntoEstado(@PathVariable Long id) {
        try {
            rutaPuntoEstadoServiceImplement.delete(id);
            return Messages.RPE_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR + Messages.RUTAPE);
        }
    }

}

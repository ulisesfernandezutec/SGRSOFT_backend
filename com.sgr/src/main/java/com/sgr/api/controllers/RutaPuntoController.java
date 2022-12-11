package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaPuntoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.RutaPunto;
import com.sgr.entities.dto.RutaPuntoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RestController
public class RutaPuntoController {
    @Autowired
    RutaPuntoServiceImplement rutaPuntoServiceImplement;

    // getall
    @GetMapping("/rp")
    public List<RutaPunto> getAll() {
        try{
            return rutaPuntoServiceImplement.list();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.RUTAP);
        }
    }
    // getone
    @GetMapping("/rp/{id}")
    public RutaPunto getRutaPunto(@PathVariable("id") String id) {
        try{
            return rutaPuntoServiceImplement.getById(Long.parseLong(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.RUTAP);
        }
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + Messages.RUTAP);
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR + Messages.RUTAP);
        }
    }
    // delete
    @DeleteMapping("/rp/{id}")
    public String deleteRutaPunto(@PathVariable Long id) {
        try {
            rutaPuntoServiceImplement.delete(id);
            return Messages.RP_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+ Messages.RUTAP);
        }
    }
}

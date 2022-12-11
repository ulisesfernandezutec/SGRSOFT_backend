package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.PuntoMapaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoMapa;
import com.sgr.entities.dto.PuntoMapaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
public class PuntoMapaController {

    @Autowired
    PuntoMapaServiceImplement puntoMapaServiceImplement;

    // getall
    @GetMapping("/pmapa")
    public List<PuntoMapa> getAll() {
        try {
            return puntoMapaServiceImplement.list();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
        }
    }
    // getone
    @GetMapping("/pmapa/{id}")
    public PuntoMapa getPuntoDisposicionFinal(@PathVariable("id") String id) {
        try {
            return puntoMapaServiceImplement.getById(Long.parseLong(id));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
        }
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+e.getMessage());
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+e.getMessage());
        }
    }
    // delete
    @DeleteMapping("/pmapa/{id}")
    public String deletePuntoDisposicionFinal(@PathVariable Long id) {
        try {
            puntoMapaServiceImplement.delete(id);
            return Messages.PNT_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR);
        }
    }
}

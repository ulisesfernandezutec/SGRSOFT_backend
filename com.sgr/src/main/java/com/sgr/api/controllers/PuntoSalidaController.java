package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.PuntoSalidaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoSalida;
import com.sgr.entities.dto.PuntoSalidaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
public class PuntoSalidaController {

    @Autowired
    PuntoSalidaServiceImplement puntoSalidaServiceImplement;

    // getall
    @GetMapping("/psalida")
    public List<PuntoSalida> getAll() {
        try{
            return puntoSalidaServiceImplement.list();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+Messages.PUNTOS_DP);
        }
    }

    // getone
    @GetMapping("/psalida/{id}")
    public PuntoSalida getPuntoSalida(@PathVariable("id") String id) {
        try{
            return puntoSalidaServiceImplement.getById(Long.parseLong(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+Messages.PUNTOS_DP);
        }
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+Messages.PUNTOS_DP);
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
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+Messages.PUNTOS_DP);
        }
    }
    // delete
    @DeleteMapping("/psalida/{id}")
    public String deletePuntoSalida(@PathVariable Long id) {
        try {
            puntoSalidaServiceImplement.delete(id);
            return Messages.PNS_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+Messages.PUNTOS_DP);
        }
    }
}

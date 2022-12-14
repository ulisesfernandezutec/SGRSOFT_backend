package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.PuntoDisposicionFinalServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoDisposicionFinal;
import com.sgr.entities.dto.PuntoDisposicionFinalDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@Slf4j
public class PuntoDisposicionFinalController {
    @Autowired
    PuntoDisposicionFinalServiceImplement puntoDisposicionFinalServiceImplement;

    // getall
    @GetMapping("/pdf")
    public List<PuntoDisposicionFinal> getAll() {
        try{
            return puntoDisposicionFinalServiceImplement.list();
        }catch(Exception e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR +e.getMessage());
        }
    }
    // getone
    @GetMapping("/pdf/{id}")
    public PuntoDisposicionFinal getPuntoDisposicionFinal(@PathVariable("id") String id) {
        try {
            return puntoDisposicionFinalServiceImplement.getById(Long.parseLong(id));
        }catch(Exception e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
        }
    }

    // setone
    @PostMapping("/pdf")
    public String setPuntoDisposicionFinal(@RequestBody PuntoDisposicionFinalDTO puntoDisposicionFinalDTO) {
        PuntoDisposicionFinal puntoDisposicionFinal = new PuntoDisposicionFinal();
        puntoDisposicionFinal.set_id(puntoDisposicionFinalDTO.getId());
        puntoDisposicionFinal.setLongitud(puntoDisposicionFinalDTO.getLongitud());
        puntoDisposicionFinal.setLongitud(puntoDisposicionFinalDTO.getLatitud());
        puntoDisposicionFinal.setDireccion(puntoDisposicionFinalDTO.getDireccion());
        puntoDisposicionFinal.setDescripcion(puntoDisposicionFinalDTO.getDescripcion());
        try {
            Long id = 0L;
            puntoDisposicionFinal.set_id(id);
            puntoDisposicionFinalServiceImplement.create(puntoDisposicionFinal);
            return new Gson().fromJson(Messages.PDF_CREADO+ id, JsonObject.class).toString();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+e.getMessage());
        }
    }
    // update
    @PutMapping("/pdf")
    public boolean updatePuntoDisposicionFinal(@RequestBody PuntoDisposicionFinalDTO puntoDisposicionFinalDTO) {
        PuntoDisposicionFinal puntoDisposicionFinal = new PuntoDisposicionFinal();
        puntoDisposicionFinal.set_id(puntoDisposicionFinalDTO.getId());
        puntoDisposicionFinal.setLongitud(puntoDisposicionFinalDTO.getLongitud());
        puntoDisposicionFinal.setLongitud(puntoDisposicionFinalDTO.getLatitud());
        puntoDisposicionFinal.setDireccion(puntoDisposicionFinalDTO.getDireccion());
        puntoDisposicionFinal.setDescripcion(puntoDisposicionFinalDTO.getDescripcion());
        try {
            if (puntoDisposicionFinalServiceImplement.getById(puntoDisposicionFinal.get_id()) != null) {
                puntoDisposicionFinalServiceImplement.update(puntoDisposicionFinal);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+e.getMessage());
        }
    }
    // delete
    @DeleteMapping("/pdf/{id}")
    public String deletePuntoDisposicionFinal(@PathVariable Long id) {
        try {
            puntoDisposicionFinalServiceImplement.delete(id);
            return Messages.PDF_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+e.getMessage());
        }
    }
}

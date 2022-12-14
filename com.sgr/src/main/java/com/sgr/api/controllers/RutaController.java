package com.sgr.api.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.RutaServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.Ruta;
import com.sgr.entities.dto.FromToDTO;
import com.sgr.entities.dto.RutaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@Slf4j
public class RutaController {
    @Autowired
    RutaServiceImplement rutaServiceImplement;
    // getall
    @GetMapping("/ruta")
    public List<Ruta> getAll() {
        try{
        return rutaServiceImplement.list();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
        }
    }
    //between
    @GetMapping("/ruta/btw")
    public List<Ruta> getBetween(FromToDTO fromToDTO)
    {
        try{
            return rutaServiceImplement.between(fromToDTO.getFrom(), fromToDTO.getFrom());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
        }
    }
    // getone
    @GetMapping("/ruta/{id}")
    public Ruta getRutaPunto(@PathVariable("id") String id) {
        try{
            return rutaServiceImplement.getById(Long.parseLong(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
        }
    }
    // setone
    @PostMapping("/ruta")
    public String setRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = new Ruta();
        ruta.set_id(rutaDTO.get_id());
        ruta.setVehiculo(rutaDTO.getVehiculo());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setAdministrador(rutaDTO.getAdministrador());
        ruta.setBound(rutaDTO.getBound());
        ruta.setPuntos(rutaDTO.getPuntos());
        ruta.setNombre(rutaDTO.getNombre());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setSalida(rutaDTO.getSalida());
        ruta.setEstado(rutaDTO.getEstado());
        ruta.setDisposicionFinal(rutaDTO.getDisposicionFinal());
        ruta.setFecha(rutaDTO.getFecha());
        ruta.setEstado(rutaDTO.getEstado());
        ruta.setDistancia(rutaDTO.getDistancia());
        ruta.setTiempoTrabajo(rutaDTO.getTiempoTrabajo());
        ruta.setTiempoTraslado(rutaDTO.getTiempoTraslado());

        try {
            Long id = 0L;
            ruta.set_id(id);
            rutaServiceImplement.create(ruta);
            return new Gson().fromJson(Messages.RT_CREADO + id, JsonObject.class).toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + e.getMessage());
        }
    }
    // update
    @PutMapping("/ruta")
    public boolean updateRuta(@RequestBody RutaDTO rutaDTO) {
        Ruta ruta = new Ruta();
        ruta.set_id(rutaDTO.get_id());
        ruta.setVehiculo(rutaDTO.getVehiculo());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setAdministrador(rutaDTO.getAdministrador());
        ruta.setBound(rutaDTO.getBound());
        ruta.setPuntos(rutaDTO.getPuntos());
        ruta.setNombre(rutaDTO.getNombre());
        ruta.setChofer(rutaDTO.getChofer());
        ruta.setSalida(rutaDTO.getSalida());
        ruta.setEstado(rutaDTO.getEstado());
        ruta.setDisposicionFinal(rutaDTO.getDisposicionFinal());
        ruta.setFecha(rutaDTO.getFecha());
        ruta.setEstado(rutaDTO.getEstado());
        ruta.setDistancia(rutaDTO.getDistancia());
        ruta.setTiempoTrabajo(rutaDTO.getTiempoTrabajo());
        ruta.setTiempoTraslado(rutaDTO.getTiempoTraslado());
        try {
            if (rutaServiceImplement.getById(ruta.get_id()) != null) {
                rutaServiceImplement.update(ruta);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR + e.getMessage());
        }
    }
    // delete
    @DeleteMapping("/ruta/{id}")
    public String deleteRuta(@PathVariable Long id) {
        try {
            rutaServiceImplement.delete(id);
            return Messages.RT_ELIMINADO;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR + e.getMessage());
        }
    }
}

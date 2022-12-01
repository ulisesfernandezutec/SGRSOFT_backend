package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.PuntoSalidaRepository;
import com.sgr.api.interfaces.service.PuntoSalidaService;
import com.sgr.entities.PuntoMapa;
import com.sgr.entities.PuntoSalida;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@Transactional
public class PuntoSalidaServiceImplement implements PuntoSalidaService {
    @Autowired
    PuntoSalidaRepository puntoSalidaRepository;

    @Override
    public PuntoSalida create(PuntoSalida ps) {
        if (ps.get_id() != 999999996L) {
            ps.set_id(new Date().getTime());
        }
        return puntoSalidaRepository.save(ps);
    }

    @Override
    public PuntoSalida update(PuntoSalida ps) {
        Optional<PuntoSalida> pso = this.puntoSalidaRepository.findById(Long.parseLong(String.valueOf(ps.get_id())));

        if (pso.isPresent()) {
            PuntoSalida psf = pso.get();
            psf.set_id(ps.get_id());
            psf.setDescripcion(ps.getDescripcion());
            psf.setDireccion(ps.getDireccion());
            psf.setLatitud(ps.getLatitud());
            psf.setLongitud(ps.getLongitud());
            psf.setEnRuta(ps.isEnRuta());
            this.puntoSalidaRepository.save(psf);
        }
        Optional<PuntoSalida> result = this.puntoSalidaRepository.findById(Long.parseLong(String.valueOf(ps.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public PuntoSalida getById(long id) {
        Optional<PuntoSalida> pdr = this.puntoSalidaRepository.findById(id);
        return pdr.isPresent() ? pdr.get() : null;
    }

    @Override
    public boolean delete(long id) {
        Optional<PuntoSalida> pdr = this.puntoSalidaRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.puntoSalidaRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public List<PuntoSalida> list() { return this.puntoSalidaRepository.findAll(); }
}

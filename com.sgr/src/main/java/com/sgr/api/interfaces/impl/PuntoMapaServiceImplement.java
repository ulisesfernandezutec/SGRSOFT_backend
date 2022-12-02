package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.PuntoMapaRepository;
import com.sgr.api.interfaces.service.PuntoMapaService;
import com.sgr.entities.PuntoMapa;
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
public class PuntoMapaServiceImplement implements PuntoMapaService {

    @Autowired
    PuntoMapaRepository puntoMapaRepository;

    @Override
    public PuntoMapa create(PuntoMapa pdm) {
        if (pdm.get_id() != 999999996L) {
            pdm.set_id(new Date().getTime());
        }
        return puntoMapaRepository.save(pdm);
    }

    @Override
    public PuntoMapa update(PuntoMapa pdm) {
        Optional<PuntoMapa> pdo = this.puntoMapaRepository.findById(Long.parseLong(String.valueOf(pdm.get_id())));

        if (pdo.isPresent()) {
            PuntoMapa pm = pdo.get();
            pm.set_id(pdm.get_id());
            pm.setDescripcion(pdm.getDescripcion());
            pm.setDireccion(pdm.getDireccion());
            pm.setLatitud(pdm.getLatitud());
            pm.setLongitud(pdm.getLongitud());
            pm.setEnRuta(pdm.isEnRuta());
            this.puntoMapaRepository.save(pm);
        }
        Optional<PuntoMapa> result = this.puntoMapaRepository.findById(Long.parseLong(String.valueOf(pdm.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public PuntoMapa getById(long id) {
        Optional<PuntoMapa> pdr = this.puntoMapaRepository.findById(id);
        return pdr.isPresent() ? pdr.get() : null;
    }

    @Override
    public boolean delete(long id) {
        Optional<PuntoMapa> pdr = this.puntoMapaRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.puntoMapaRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<PuntoMapa> list() { return this.puntoMapaRepository.findAll(); }
}

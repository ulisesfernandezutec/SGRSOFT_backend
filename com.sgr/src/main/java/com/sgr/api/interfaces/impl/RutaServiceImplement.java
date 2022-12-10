package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.RutaRepository;
import com.sgr.api.interfaces.service.RutaService;
import com.sgr.entities.Ruta;
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
public class RutaServiceImplement implements RutaService {
    @Autowired
    RutaRepository rutaRepository;

    @Override
    public Ruta create(Ruta rt) {
        if (rt.get_id() != 999999996L) {
            rt.set_id(new Date().getTime());
        }
        return rutaRepository.save(rt);
    }

    @Override
    public Ruta update(Ruta rt) {
        Optional<Ruta> rto = this.rutaRepository.findById(Long.parseLong(String.valueOf(rt.get_id())));

        if (rto.isPresent()) {
            Ruta rf = rto.get();rf.set_id(rt.get_id());
           rf.setAdministrador(rt.getAdministrador());
           rf.setPuntos(rt.getPuntos());
           rf.setNombre(rt.getNombre());
           rf.setChofer(rt.getChofer());
           rf.setBound(rt.getBound());
           rf.setVehiculo(rt.getVehiculo());
           this.rutaRepository.save(rf);
        }
        Optional<Ruta> result = this.rutaRepository.findById(Long.parseLong(String.valueOf(rt.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public Ruta getById(long id) {
        Optional<Ruta> pdr = this.rutaRepository.findById(id);
        return pdr.isPresent()?pdr.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<Ruta> pdr = this.rutaRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.rutaRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<Ruta> list() { return this.rutaRepository.findAll(); }

    @Override
    public List<Ruta> between(long from, long to) {
        return this.rutaRepository.findBy_idBetween(from,to);
    }

}

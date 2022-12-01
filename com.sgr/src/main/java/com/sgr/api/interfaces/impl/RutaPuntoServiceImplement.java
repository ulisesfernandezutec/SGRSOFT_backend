package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.RutaPuntoEstadoRepository;
import com.sgr.api.interfaces.repository.RutaPuntoRepository;
import com.sgr.api.interfaces.service.RutaPuntoService;
import com.sgr.entities.RutaPunto;
import com.sgr.entities.RutaPuntoEstado;
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
public class RutaPuntoServiceImplement implements RutaPuntoService {
    @Autowired
    RutaPuntoRepository rutaPuntoRepository;

    @Override
    public RutaPunto create(RutaPunto rp) {
        if (rp.get_id() != 999999996L) {
            rp.set_id(new Date().getTime());
        }
        return rutaPuntoRepository.save(rp);
    }

    @Override
    public RutaPunto update(RutaPunto rp) {
        Optional<RutaPunto> rpo = this.rutaPuntoRepository.findById(Long.parseLong(String.valueOf(rp.get_id())));

        if (rpo.isPresent()) {
            RutaPunto rpf = rpo.get();
            rpf.set_id(rp.get_id());
            rpf.setPunto(rp.getPunto());
            rpf.setEstado(rp.getEstado());
            rpf.setGoogleDistance(rp.getGoogleDistance());
            rpf.setGoogleDuration(rp.getGoogleDuration());
            this.rutaPuntoRepository.save(rpf);
        }
        Optional<RutaPunto> result = this.rutaPuntoRepository.findById(Long.parseLong(String.valueOf(rp.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public RutaPunto getById(long id) {
        Optional<RutaPunto> pdr = this.rutaPuntoRepository.findById(id);
        return pdr.isPresent()?pdr.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<RutaPunto> pdr = this.rutaPuntoRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.rutaPuntoRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<RutaPunto> list() { return this.rutaPuntoRepository.findAll(); }
}

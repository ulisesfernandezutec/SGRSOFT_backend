package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.RutaPuntoEstadoRepository;
import com.sgr.api.interfaces.service.RutaPuntoEstadoService;
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
public class RutaPuntoEstadoServiceImplement implements RutaPuntoEstadoService {

    @Autowired
    RutaPuntoEstadoRepository rutaPuntoEstadoRepository;

    @Override
    public RutaPuntoEstado create(RutaPuntoEstado rpe) {
        if (rpe.get_id() != 999999996L) {
            rpe.set_id(new Date().getTime());
        }
        return rutaPuntoEstadoRepository.save(rpe);
    }

    @Override
    public RutaPuntoEstado update(RutaPuntoEstado rpe) {
        Optional<RutaPuntoEstado> rpeo = this.rutaPuntoEstadoRepository.findById(Long.parseLong(String.valueOf(rpe.get_id())));

        if (rpeo.isPresent()) {
            RutaPuntoEstado rpef = rpeo.get();
            rpef.set_id(rpe.get_id());
            rpef.setDescripcion(rpe.getDescripcion());
            rpef.setNombre(rpe.getNombre());
            this.rutaPuntoEstadoRepository.save(rpef);
        }
        Optional<RutaPuntoEstado> result = this.rutaPuntoEstadoRepository.findById(Long.parseLong(String.valueOf(rpe.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public RutaPuntoEstado getById(long id) {
        Optional<RutaPuntoEstado> pdr = this.rutaPuntoEstadoRepository.findById(id);
        return pdr.isPresent()?pdr.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<RutaPuntoEstado> pdr = this.rutaPuntoEstadoRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.rutaPuntoEstadoRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<RutaPuntoEstado> list() { return this.rutaPuntoEstadoRepository.findAll(); }
}

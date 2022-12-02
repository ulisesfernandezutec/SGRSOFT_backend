package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.repository.PuntoDisposicionFinalRepository;
import com.sgr.api.interfaces.service.PuntoDisposicionFinalService;
import com.sgr.entities.PuntoDisposicionFinal;
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
public class PuntoDisposicionFinalServiceImplement  implements PuntoDisposicionFinalService {
    @Autowired
    PuntoDisposicionFinalRepository puntoDisposicionFinalRepository;

    @Override
    public PuntoDisposicionFinal create(PuntoDisposicionFinal pdr) {
        if (pdr.get_id() != 999999996L) {
            pdr.set_id(new Date().getTime());
        }
        return puntoDisposicionFinalRepository.save(pdr);
    }

    @Override
    public PuntoDisposicionFinal update(PuntoDisposicionFinal pdr) {
        Optional<PuntoDisposicionFinal> pre = this.puntoDisposicionFinalRepository.findById(Long.parseLong(String.valueOf(pdr.get_id())));

        if (pre.isPresent()) {
            PuntoDisposicionFinal pdf = pre.get();
            pdf.set_id(pdr.get_id());
            pdf.setDescripcion(pdr.getDescripcion());
            pdf.setDireccion(pdr.getDireccion());
            pdf.setTipos(pdr.getTipos());
            pdf.setLatitud(pdr.getLatitud());
            pdf.setLongitud(pdr.getLongitud());
            pdf.setEnRuta(pdr.isEnRuta());
            this.puntoDisposicionFinalRepository.save(pdf);
        }
        Optional<PuntoDisposicionFinal> result = this.puntoDisposicionFinalRepository.findById(Long.parseLong(String.valueOf(pdr.get_id())));
        return result.isPresent() ? result.get():null;
    }

    @Override
    public PuntoDisposicionFinal getById(long id) {
        Optional<PuntoDisposicionFinal> pdr = this.puntoDisposicionFinalRepository.findById(id);
        return pdr.isPresent() ? pdr.get() : null;
    }

    @Override
    public boolean delete(long id) {
        Optional<PuntoDisposicionFinal> pdr = this.puntoDisposicionFinalRepository.findById(id);
        if (pdr.isPresent()) {
            try {
                this.puntoDisposicionFinalRepository.delete(pdr.get());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<PuntoDisposicionFinal> list() {
        return this.puntoDisposicionFinalRepository.findAll();
    }
}

package com.sgr.api.interfaces.service;

import com.sgr.entities.PuntoMapa;
import java.util.List;

public interface PuntoMapaService {

    PuntoMapa create(PuntoMapa pdr);

    PuntoMapa update(PuntoMapa pdr);

    PuntoMapa getById(long id);

    boolean delete(long id);

    List< PuntoMapa > list();
}

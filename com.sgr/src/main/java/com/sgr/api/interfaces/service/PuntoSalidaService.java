package com.sgr.api.interfaces.service;

import com.sgr.entities.PuntoSalida;
import java.util.List;

public interface PuntoSalidaService {
    PuntoSalida create(PuntoSalida pdr);

    PuntoSalida update(PuntoSalida pdr);

    PuntoSalida getById(long id);

    boolean delete(long id);

    List< PuntoSalida > list();
}

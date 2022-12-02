package com.sgr.api.interfaces.service;

import com.sgr.entities.PuntoDisposicionFinal;
import java.util.List;

public interface PuntoDisposicionFinalService {
    PuntoDisposicionFinal create(PuntoDisposicionFinal pdr);

    PuntoDisposicionFinal update(PuntoDisposicionFinal pdr);

    PuntoDisposicionFinal getById(long id);

    boolean delete(long id);

    List< PuntoDisposicionFinal > list();
}

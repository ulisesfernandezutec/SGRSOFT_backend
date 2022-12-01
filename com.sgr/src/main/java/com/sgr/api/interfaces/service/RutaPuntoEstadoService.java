package com.sgr.api.interfaces.service;

import com.sgr.entities.RutaPuntoEstado;

import java.util.List;

public interface RutaPuntoEstadoService {

    RutaPuntoEstado create(RutaPuntoEstado pdr);

    RutaPuntoEstado update(RutaPuntoEstado pdr);

    RutaPuntoEstado getById(long id);

    boolean delete(long id);

    List< RutaPuntoEstado > list();
}

package com.sgr.api.interfaces.service;

import com.sgr.entities.RutaPunto;

import java.util.List;

public interface RutaPuntoService {

    RutaPunto create(RutaPunto pdr);

    RutaPunto update(RutaPunto pdr);

    RutaPunto getById(long id);

    boolean delete(long id);

    List< RutaPunto > list();
}

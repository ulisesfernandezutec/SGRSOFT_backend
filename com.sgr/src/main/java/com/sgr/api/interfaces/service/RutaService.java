package com.sgr.api.interfaces.service;

import com.sgr.entities.Ruta;

import java.util.List;

public interface RutaService {

    Ruta create(Ruta pdr);

    Ruta update(Ruta pdr);

    Ruta getById(long id);

    boolean delete(long id);

    List< Ruta > list();
}

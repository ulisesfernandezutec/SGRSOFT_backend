package com.sgr.api.interfaces.service.google;
import com.sgr.entities.google.GoogleLocation;

import java.util.List;

public interface GoogleLocationService {
    GoogleLocation create(GoogleLocation gl);

    GoogleLocation update(GoogleLocation gl);

    GoogleLocation getById(long id);

    boolean delete(long id);

    List< GoogleLocation > list();
}

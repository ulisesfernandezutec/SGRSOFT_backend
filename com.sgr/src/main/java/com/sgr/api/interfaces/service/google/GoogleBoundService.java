package com.sgr.api.interfaces.service.google;

import com.sgr.entities.google.GoogleBound;
import com.sgr.entities.google.GoogleLocation;

import java.util.List;

public interface GoogleBoundService {


    GoogleBound create(GoogleBound gb);

    GoogleBound update(GoogleBound gb);

    GoogleBound getByNortheastSouthwest(GoogleLocation northeast, GoogleLocation southwest);

    GoogleBound getById(long _id);

    boolean delete(long id);

    List< GoogleBound > list();
}

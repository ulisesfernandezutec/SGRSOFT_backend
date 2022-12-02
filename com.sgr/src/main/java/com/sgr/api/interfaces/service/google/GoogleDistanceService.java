package com.sgr.api.interfaces.service.google;

import com.sgr.entities.google.GoogleDistance;
import java.util.List;

public interface GoogleDistanceService {

    GoogleDistance create(GoogleDistance gd);

    GoogleDistance update(GoogleDistance gd);

    GoogleDistance getById(long id);

    boolean delete(long id);

    List< GoogleDistance > list();
}

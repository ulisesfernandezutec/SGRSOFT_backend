package com.sgr.api.interfaces.repository.google;

import com.sgr.entities.google.GoogleLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoogleLocationRepository extends MongoRepository<GoogleLocation, Long > {
}

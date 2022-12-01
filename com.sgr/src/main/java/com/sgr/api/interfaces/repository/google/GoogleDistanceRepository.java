package com.sgr.api.interfaces.repository.google;

import com.sgr.entities.google.GoogleDistance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoogleDistanceRepository extends MongoRepository<GoogleDistance, Long > {
}

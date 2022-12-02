package com.sgr.api.interfaces.repository.google;

import com.sgr.entities.google.GoogleBound;
import com.sgr.entities.google.GoogleLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GoogleBoundRepository extends MongoRepository<GoogleBound, Long > {

    Optional<GoogleBound> findByNortheastAndSouthwest(GoogleLocation northeast, GoogleLocation southwest);


}

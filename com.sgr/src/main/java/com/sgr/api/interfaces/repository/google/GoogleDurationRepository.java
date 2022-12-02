package com.sgr.api.interfaces.repository.google;

import com.sgr.entities.google.GoogleDuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GoogleDurationRepository extends MongoRepository<GoogleDuration, Long > {

    Optional<GoogleDuration> findByText(String text);

    Optional<GoogleDuration> findByValue(int value);

    Optional<GoogleDuration> findByTextAndValue(String text, int value);
}

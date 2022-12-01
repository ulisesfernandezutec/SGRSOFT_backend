package com.sgr.api.interfaces.impl.google;

import com.sgr.api.interfaces.repository.google.GoogleBoundRepository;
import com.sgr.api.interfaces.service.google.GoogleBoundService;
import com.sgr.entities.google.GoogleBound;
import com.sgr.entities.google.GoogleLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@Transactional
public class GoogleBoundServiceImplement implements GoogleBoundService {

    @Autowired
    GoogleBoundRepository googleBoundRepository;

    @Override
    public GoogleBound create(GoogleBound gb) {
        if (gb.get_id() != 999999996L) {
            gb.set_id(new Date().getTime());
        }
        return googleBoundRepository.save(gb);
    }

    @Override
    public GoogleBound update(GoogleBound gb) {
        googleBoundRepository.save(gb);
        Optional<GoogleBound> optional = googleBoundRepository.findById(gb.get_id());
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleBound getByNortheastSouthwest(GoogleLocation northeast, GoogleLocation southwest) {
           Optional<GoogleBound> optional = googleBoundRepository.findByNortheastAndSouthwest(northeast,southwest);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleBound getById(long id) {
        Optional<GoogleBound> optional = googleBoundRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<GoogleBound> optional = googleBoundRepository.findById(id);
        if(optional.isPresent()) {
            googleBoundRepository.delete(optional.get());
        }
        return !googleBoundRepository.findById(id).isPresent();
    }

    @Override
    public List<GoogleBound> list() {
        return googleBoundRepository.findAll();
    }
}

package com.sgr.api.interfaces.impl.google;

import com.sgr.api.interfaces.repository.google.GoogleLocationRepository;
import com.sgr.api.interfaces.service.google.GoogleLocationService;
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
public class GoogleLocationServiceImplement implements GoogleLocationService {
    @Autowired
    GoogleLocationRepository googleLocationRepository;

    @Override
    public GoogleLocation create(GoogleLocation gl) {
        if (gl.get_id() != 999999996L) {
            gl.set_id(new Date().getTime());
        }
        return googleLocationRepository.save(gl);
    }

    @Override
    public GoogleLocation update(GoogleLocation gl) {
        googleLocationRepository.save(gl);
        Optional<GoogleLocation> optional = googleLocationRepository.findById(gl.get_id());
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleLocation getById(long id) {
        Optional<GoogleLocation> optional = googleLocationRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<GoogleLocation> optional = googleLocationRepository.findById(id);
        if(optional.isPresent()) {
            googleLocationRepository.delete(optional.get());
        }
        return !googleLocationRepository.findById(id).isPresent();
    }

    @Override
    public List<GoogleLocation> list() {
            return googleLocationRepository.findAll();
    }
}

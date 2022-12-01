package com.sgr.api.interfaces.impl.google;

import com.sgr.api.interfaces.repository.google.GoogleDistanceRepository;
import com.sgr.api.interfaces.service.google.GoogleDistanceService;
import com.sgr.entities.google.GoogleDistance;
import com.sgr.entities.google.GoogleLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@Transactional
public class GoogleDistanceServiceImplement implements GoogleDistanceService {
    @Autowired
    GoogleDistanceRepository googleDistanceRepository;

    @Override
    public GoogleDistance create(GoogleDistance gd) {
        return googleDistanceRepository.save(gd);
    }

    @Override
    public GoogleDistance update(GoogleDistance gd) {
        return googleDistanceRepository.save(gd);
    }

    @Override
    public GoogleDistance getById(long id) {
        Optional<GoogleDistance> optional = googleDistanceRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<GoogleDistance> optional = googleDistanceRepository.findById(id);
        if(optional.isPresent()){
            googleDistanceRepository.delete(optional.get());
        }
        return !googleDistanceRepository.findById(id).isPresent();
    }

    @Override
    public List<GoogleDistance> list() {
        return googleDistanceRepository.findAll();
    }
}

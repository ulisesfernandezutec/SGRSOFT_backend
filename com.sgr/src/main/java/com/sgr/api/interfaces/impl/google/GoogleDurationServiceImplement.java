package com.sgr.api.interfaces.impl.google;

import com.sgr.api.interfaces.repository.google.GoogleDurationRepository;
import com.sgr.api.interfaces.service.google.GoogleDurationService;
import com.sgr.entities.google.GoogleDuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@Transactional
public class GoogleDurationServiceImplement implements GoogleDurationService {
    @Autowired
    GoogleDurationRepository googleDurationRepository;

    @Override
    public GoogleDuration create(GoogleDuration gd) {
        return googleDurationRepository.save(gd);
    }

    @Override
    public GoogleDuration update(GoogleDuration gd) {
        return googleDurationRepository.save(gd);
    }

    @Override
    public GoogleDuration getBytext(String text) {
        Optional <GoogleDuration> optional = googleDurationRepository.findByText(text);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleDuration getByValue(int value) {
        Optional <GoogleDuration> optional = googleDurationRepository.findByValue(value);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleDuration getByTextValue(String text, int value) {
        Optional<GoogleDuration> optional = googleDurationRepository.findByTextAndValue(text,value);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public GoogleDuration getById(long id) {
        Optional<GoogleDuration> optional = googleDurationRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }

    @Override
    public boolean delete(long id) {
        Optional<GoogleDuration> optional = googleDurationRepository.findById(id);
        if(optional.isPresent()){
            googleDurationRepository.delete(optional.get());
        }
        return !googleDurationRepository.findById(id).isPresent();
    }

    @Override
    public List<GoogleDuration> list() {
        return googleDurationRepository.findAll();
    }
}

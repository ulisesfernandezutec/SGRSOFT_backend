package com.sgr.api.interfaces.service.google;

import com.sgr.entities.google.GoogleDuration;
import java.util.List;

public interface GoogleDurationService {

    GoogleDuration create(GoogleDuration gd);

    GoogleDuration update(GoogleDuration gd);

    GoogleDuration getBytext(String text);

    GoogleDuration getByValue(int value);

    GoogleDuration getByTextValue(String text, int value);

    GoogleDuration getById(long id);

    boolean delete(long id);

    List< GoogleDuration > list();
}

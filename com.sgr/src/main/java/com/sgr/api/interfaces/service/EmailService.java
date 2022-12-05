package com.sgr.api.interfaces.service;

import com.sgr.entities.Email;

public interface EmailService {

    String sendSimpleMail(Email details);

}

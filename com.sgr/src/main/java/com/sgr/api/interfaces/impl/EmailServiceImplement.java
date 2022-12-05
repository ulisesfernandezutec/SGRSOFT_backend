package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.service.EmailService;
import com.sgr.bussines.Messages;
import com.sgr.entities.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImplement implements EmailService {
    @Autowired
    private JavaMailSender javaMail;

    private static final String USERNAME = "noreplysgrsoft@gmail.com";


    public String sendSimpleMail(Email details)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(USERNAME);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            javaMail.send(mailMessage);
            log.info(Messages.EMAIL_SEND+" "+details.getRecipient());
            return Messages.EMAIL_SEND+" "+details.getRecipient();
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            log.info(Messages.EMAIL_ERROR);
            return Messages.EMAIL_ERROR;
        }
    }
}

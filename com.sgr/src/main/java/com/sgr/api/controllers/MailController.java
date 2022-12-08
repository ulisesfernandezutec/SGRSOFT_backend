package com.sgr.api.controllers;

import com.sgr.api.interfaces.service.EmailService;
import com.sgr.entities.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/mail")
    public String
    sendMail(@RequestBody Email details)
    {
        return emailService.sendSimpleMail(details);
    }

}

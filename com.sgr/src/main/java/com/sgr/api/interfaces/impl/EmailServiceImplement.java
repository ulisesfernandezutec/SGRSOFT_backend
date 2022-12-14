package com.sgr.api.interfaces.impl;

import com.sgr.api.interfaces.service.EmailService;
import com.sgr.bussines.Messages;
import com.sgr.bussines.security.AESEncryptionDecryption;
import com.sgr.entities.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
@Service
public class EmailServiceImplement implements EmailService {

    private static final String USERNAME = "noreplysgrsoft@gmail.com";
    public String sendSimpleMail(Email details)
    {
        try {
            AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
            final String username = USERNAME;
            final String password = aesEncryptionDecryption.decrypt("PCsqbYd0ndt49Sp43Le14sn/gcLpGzU+f4V0WSKn7lI=");

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(USERNAME));
                message.setRecipients( Message.RecipientType.TO, InternetAddress.parse(details.getRecipient()));
                message.setSubject(details.getSubject());
                message.setText(details.getMsgBody());
                Transport.send(message);
                log.info(Messages.EMAIL_SEND + " " + details.getRecipient());
                return Messages.EMAIL_SEND + " " + details.getRecipient();

            } catch (Exception e) {
                log.info(Messages.EMAIL_ERROR);
                return Messages.EMAIL_ERROR;
            }
        } catch (Exception e) {
            log.info(Messages.EMAIL_ERROR);
            return Messages.EMAIL_ERROR;
        }
    }
}

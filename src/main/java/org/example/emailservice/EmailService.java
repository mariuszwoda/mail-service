package org.example.emailservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private final JavaMailSender mailSender;

    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDTO.getTo());
        message.setSubject(emailDTO.getSubject());
        message.setText(emailDTO.getBody());
        if (emailDTO.getCc() != null) {
            message.setCc(emailDTO.getCc().toArray(new String[0]));
        }
        if (emailDTO.getBcc() != null) {
            message.setBcc(emailDTO.getBcc().toArray(new String[0]));
        }
        mailSender.send(message);
    }
}

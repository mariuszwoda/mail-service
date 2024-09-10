package org.example.emailservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender mailSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendEmail() throws MessagingException {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo("test@example.com");
        emailDTO.setSubject("Test Subject");
        emailDTO.setBody("Test Body");

        emailService.sendEmail(emailDTO);

        // Verify that send method was called with a SimpleMailMessage
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}

package org.example.emailservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/email")
@Tag(name = "Email Controller", description = "APIs for managing mails")

public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Send email", description = "Starts the email job with the given parameters")
    public String sendEmail(@RequestBody EmailDTO emailDTO) {
        try {
            emailService.sendEmail(emailDTO);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}

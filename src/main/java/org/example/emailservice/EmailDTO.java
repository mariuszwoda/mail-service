package org.example.emailservice;

import lombok.Data;
import java.util.List;

@Data
public class EmailDTO {
    private String to;
    private String subject;
    private String body;
    private List<String> cc;
    private List<String> bcc;
    private List<String> attachments; // File paths or byte arrays
}

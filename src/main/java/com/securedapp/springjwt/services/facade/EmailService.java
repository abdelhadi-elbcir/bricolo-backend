package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}

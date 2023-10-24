package com.securedapp.springjwt.controllers;


import com.securedapp.springjwt.models.EmailDetails;
import com.securedapp.springjwt.services.facade.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping ("/send")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
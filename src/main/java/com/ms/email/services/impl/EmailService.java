package com.ms.email.services.impl;

import com.ms.email.dtos.request.EmailRequestDTO;
import com.ms.email.dtos.response.EmailResponseDTO;
import com.ms.email.enums.EmailStatus;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRepository;
import com.ms.email.services.IEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService implements IEmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    @Override
    public EmailResponseDTO send(EmailRequestDTO emailDTO) {
        Email email = new Email();
        email.setSendDate(LocalDateTime.now());
        BeanUtils.copyProperties(emailDTO, email);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getSender());
            message.setTo(email.getRecipient());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            emailSender.send(message);
            email.setStatus(EmailStatus.SENT);
        } catch (MailException ex) {
            email.setStatus(EmailStatus.ERROR);
        } finally {
            emailRepository.save(email);
        }

        EmailResponseDTO response = new EmailResponseDTO();
        BeanUtils.copyProperties(email, response);
        return response;
    }
}

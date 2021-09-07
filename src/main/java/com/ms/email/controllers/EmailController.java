package com.ms.email.controllers;

import com.ms.email.dtos.request.EmailRequestDTO;
import com.ms.email.dtos.response.EmailResponseDTO;
import com.ms.email.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    IEmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailResponseDTO> sendEmail(@RequestBody @Valid EmailRequestDTO emailDTO) {
        EmailResponseDTO email = emailService.send(emailDTO);

        if (Objects.isNull(email)) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}

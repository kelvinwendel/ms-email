package com.ms.email.services;

import com.ms.email.dtos.request.EmailRequestDTO;
import com.ms.email.dtos.response.EmailResponseDTO;

public interface IEmailService {
    EmailResponseDTO send(EmailRequestDTO emailDTO);
}

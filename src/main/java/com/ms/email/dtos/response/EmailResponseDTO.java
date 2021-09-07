package com.ms.email.dtos.response;

import com.ms.email.enums.EmailStatus;
import lombok.Data;

@Data
public class EmailResponseDTO {

    private String owner;

    private String sender;

    private String recipient;

    private String body;

    private EmailStatus status;
}

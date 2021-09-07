package com.ms.email.dtos.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailRequestDTO {

    @NotBlank
    private String owner;

    @NotBlank
    @Email
    private String sender;

    @NotBlank
    @Email
    private String recipient;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;
}

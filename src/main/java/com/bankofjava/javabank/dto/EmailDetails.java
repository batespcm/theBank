package com.bankofjava.javabank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDetails {
    @Schema(name = "Customer Email Address")
    private String recipient;
    @Schema(name = "Body of email")
    private String messageBody;
    @Schema(name = "Subject of email")
    private String subject;
    @Schema(name = "Email attachment(s)")
    private String attachments;

}

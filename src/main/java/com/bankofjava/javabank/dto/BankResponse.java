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
public class BankResponse {
    @Schema(name = "Error Response Code")
    private String responseCode;
    @Schema(name = "Error Response Message")
    private String responseMessage;
    @Schema(name = "Any Relevant Customer details")
    private CustomerAccountInfo customerAccountInfo;
}

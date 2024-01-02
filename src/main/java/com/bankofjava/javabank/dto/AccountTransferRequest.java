package com.bankofjava.javabank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransferRequest {
    @Schema(name = "Customer Account Sending Money")
    private String payeeAccountNumber;
    @Schema(name = "Customer Account Receiving Money")
    private String recipientAccountNumber;
    @Schema(name = "Amount of Money Sent")
    private BigDecimal amount;
}

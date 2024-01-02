package com.bankofjava.javabank.dto;

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
    private String payeeAccountNumber;
    private String recipientAccountNumber;
    private BigDecimal amount;
}

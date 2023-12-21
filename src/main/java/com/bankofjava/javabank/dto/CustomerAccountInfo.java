package com.bankofjava.javabank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountInfo {
    private String accountName;
    private String accountBalance;
    private String accountNumber;
}

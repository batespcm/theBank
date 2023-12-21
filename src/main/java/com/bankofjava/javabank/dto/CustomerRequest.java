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
public class CustomerRequest {
    private String prefix;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String pronouns;
    private String firstLineAddress;
    private String county;
    private String accountNumber;
    private String email;
    private BigDecimal accountBalance;
    private String phoneNumber;
    private String accountStatus;
}

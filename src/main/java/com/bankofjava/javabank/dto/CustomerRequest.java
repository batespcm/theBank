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
public class CustomerRequest {
    @Schema(name = "Customer Prefix")
    private String prefix;
    @Schema(name = "Customer First Name")
    private String firstName;
    @Schema(name = "Customer Last Name")
    private String lastName;
    @Schema(name = "Customer Other Names")
    private String otherName;
    @Schema(name = "Customer Gender")
    private String gender;
    @Schema(name = "Customer Pronouns")
    private String pronouns;
    @Schema(name = "Customer First Line of Address")
    private String firstLineAddress;
    @Schema(name = "Customer County")
    private String county;
    @Schema(name = "Customer PostCode")
    private String postcode;
    @Schema(name = "Customer Account Number")
    private String accountNumber;
    @Schema(name = "Customer Email address")
    private String email;
    @Schema(name = "Customer Account Balance")
    private BigDecimal accountBalance;
    @Schema(name = "Customer Telephone Number")
    private String phoneNumber;

}

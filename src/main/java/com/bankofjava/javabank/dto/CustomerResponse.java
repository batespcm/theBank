package com.bankofjava.javabank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String responseCode;
    private String responseMessage;
    private CustomerAccountInfo customerAccountInfo;
}

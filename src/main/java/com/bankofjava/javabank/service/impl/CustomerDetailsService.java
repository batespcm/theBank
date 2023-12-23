package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.CustomerRequest;
import com.bankofjava.javabank.dto.BankResponse;

public interface CustomerDetailsService {

   BankResponse createAccount(CustomerRequest customerRequest);
}

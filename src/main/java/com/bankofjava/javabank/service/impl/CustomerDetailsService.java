package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.CustomerRequest;
import com.bankofjava.javabank.dto.CustomerResponse;

public interface CustomerDetailsService {

   CustomerResponse createAccount(CustomerRequest customerRequest);
}

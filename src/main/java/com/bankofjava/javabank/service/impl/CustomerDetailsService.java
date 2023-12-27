package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.AccountEnquiryRequest;
import com.bankofjava.javabank.dto.CustomerRequest;
import com.bankofjava.javabank.dto.BankResponse;

public interface CustomerDetailsService {

   BankResponse createAccount(CustomerRequest customerRequest);
   BankResponse balanceEnquiry(AccountEnquiryRequest balanceRequest);
   String nameEnquiry(AccountEnquiryRequest nameRequest);

}

package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.AccountEnquiryRequest;
import com.bankofjava.javabank.dto.BankResponse;
import com.bankofjava.javabank.dto.CreditDebitRequest;
import com.bankofjava.javabank.dto.CustomerRequest;

public interface CustomerDetailsService {

    BankResponse createAccount(CustomerRequest customerRequest);

    BankResponse balanceEnquiry(AccountEnquiryRequest balanceRequest);

    String nameEnquiry(AccountEnquiryRequest nameRequest);

    BankResponse creditAccountTransaction(CreditDebitRequest creditRequest);
}

package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.*;

public interface CustomerDetailsService {

    BankResponse createAccount(CustomerRequest customerRequest);

    BankResponse balanceEnquiry(AccountEnquiryRequest balanceRequest);

    String nameEnquiry(AccountEnquiryRequest nameRequest);

    BankResponse creditAccountTransaction(CreditDebitRequest creditRequest);

    BankResponse debitAccountTransaction(CreditDebitRequest debitRequest);

    BankResponse accountTransferTransaction(AccountTransferRequest transferRequest);
}


package com.bankofjava.javabank.controller;

import com.bankofjava.javabank.dto.*;
import com.bankofjava.javabank.service.impl.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerDetailsService customerDetailsService;

    @PostMapping
    public BankResponse createAccount(@RequestBody CustomerRequest customerRequest) {
        return customerDetailsService.createAccount(customerRequest);
    }

    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody AccountEnquiryRequest enquiryRequest) {
        return customerDetailsService.balanceEnquiry(enquiryRequest);
    }

    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody AccountEnquiryRequest enquiryRequest) {
        return customerDetailsService.nameEnquiry(enquiryRequest);
    }

    @PostMapping("/creditAccount")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest creditRequest) {
        return customerDetailsService.creditAccountTransaction(creditRequest);
    }

    @PostMapping("/debitAccount")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest debitRequest) {
        return customerDetailsService.debitAccountTransaction(debitRequest);
    }

    @PostMapping("/transfer")
    public BankResponse accountTransfer(@RequestBody AccountTransferRequest transferRequest) {
        return customerDetailsService.accountTransferTransaction(transferRequest);
    }
}

package com.bankofjava.javabank.controller;

import com.bankofjava.javabank.dto.*;
import com.bankofjava.javabank.service.impl.CustomerDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer Account Management API")
public class CustomerController {
    @Autowired
    CustomerDetailsService customerDetailsService;

    @Operation(
            summary = "Create Account Endpoint",
            description = "Creates a new bank customer and assigns them an account number"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public BankResponse createAccount(@RequestBody CustomerRequest customerRequest) {
        return customerDetailsService.createAccount(customerRequest);
    }

    @Operation(
            summary = "Balance Enquiry Endpoint",
            description = "Given an account number, returns the account balance"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody AccountEnquiryRequest enquiryRequest) {
        return customerDetailsService.balanceEnquiry(enquiryRequest);
    }

    @Operation(
            summary = "Name Enquiry Endpoint",
            description = "Given an account number, returns the account holders full name including prefix"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody AccountEnquiryRequest enquiryRequest) {
        return customerDetailsService.nameEnquiry(enquiryRequest);
    }

    @Operation(
            summary = "Add Funds Endpoint",
            description = "Given an account number and an amount, adds money to chosen account if exists"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PostMapping("/creditAccount")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest creditRequest) {
        return customerDetailsService.creditAccountTransaction(creditRequest);
    }

    @Operation(
            summary = "Debit Funds Endpoint",
            description = "Given an account number and an amount, deducts money to chosen account if exists and if sufficient balance"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PostMapping("/debitAccount")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest debitRequest) {
        return customerDetailsService.debitAccountTransaction(debitRequest);
    }

    @Operation(
            summary = "Transfer Between Accounts Endpoint",
            description = "Given an account number for the sender and another for the recipient and an amount, adds money to chosen account if exists and if sufficient balance"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PostMapping("/transfer")
    public BankResponse accountTransfer(@RequestBody AccountTransferRequest transferRequest) {
        return customerDetailsService.accountTransferTransaction(transferRequest);
    }
}

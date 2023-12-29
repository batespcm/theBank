package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.*;
import com.bankofjava.javabank.entity.Customer;
import com.bankofjava.javabank.repository.CustomerRepository;
import com.bankofjava.javabank.utils.AccountUtils;
import com.bankofjava.javabank.utils.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmailStructureService emailStructureService;

    @Override
    public BankResponse createAccount(CustomerRequest customerRequest) {
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_ALREADY_EXISTS_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_ALREADY_EXISTS_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }

        Customer newCustomer = Customer.builder()
                .prefix(customerRequest.getPrefix())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .otherName(customerRequest.getOtherName())
                .gender(customerRequest.getGender())
                .pronouns(customerRequest.getPronouns())
                .firstLineAddress(customerRequest.getFirstLineAddress())
                .county(customerRequest.getCounty())
                .postcode(customerRequest.getPostcode())
                .accountNumber(AccountUtils.createAccountNumber())
                .email(customerRequest.getEmail())
                .accountBalance(BigDecimal.ZERO)
                .phoneNumber(customerRequest.getPhoneNumber())
                .accountStatus("ACTIVE")
                .build();

        Customer savedCustomer = customerRepository.save(newCustomer);
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedCustomer.getEmail())
                .subject("New Account Created")
                .messageBody("Congratulations on opening a new account with theBank.\nYour Account Details: \n" +
                        "Account Name: " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName() + "\nAccount Number: " + savedCustomer.getAccountNumber())
                .build();
        emailStructureService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .responseCode(ApiResponses.ACCOUNT_CREATED_CODE)
                .responseMessage(ApiResponses.ACCOUNT_CREATED_MESSAGE)
                .customerAccountInfo(CustomerAccountInfo.builder()
                        .accountBalance(savedCustomer.getAccountBalance())
                        .accountNumber(savedCustomer.getAccountNumber())
                        .accountName(savedCustomer.getFirstName() + " " + savedCustomer.getLastName() + " " + savedCustomer.getOtherName())
                        .build())
                .build();
    }


    @Override
    public BankResponse balanceEnquiry(AccountEnquiryRequest balanceRequest) {
        boolean accountExists = customerRepository.existsByAccountNumber(balanceRequest.getAccountNumber());
        if (!accountExists) {
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_DOES_NOT_EXIST_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_DOES_NOT_EXIST_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }

        Customer requestedCustomer = customerRepository.findByAccountNumber(balanceRequest.getAccountNumber());
        return BankResponse.builder()
                .responseCode(ApiResponses.ACCOUNT_FOUND_CODE)
                .responseMessage(ApiResponses.ACCOUNT_FOUND_MESSAGE)
                .customerAccountInfo(CustomerAccountInfo.builder()
                        .accountBalance(requestedCustomer.getAccountBalance())
                        .accountNumber(balanceRequest.getAccountNumber())
                        .accountName(requestedCustomer.getFirstName() + " " + requestedCustomer.getLastName())
                        .build())
                .build();
    }

    @Override
    public String nameEnquiry(AccountEnquiryRequest nameRequest) {
        boolean accountExists = customerRepository.existsByAccountNumber(nameRequest.getAccountNumber());
        if (!accountExists) {
            return ApiResponses.ACCOUNT_DOES_NOT_EXIST_MESSAGE;
        }
        Customer requestedCustomer = customerRepository.findByAccountNumber(nameRequest.getAccountNumber());
        return requestedCustomer.getFirstName() + " " + requestedCustomer.getLastName();
    }


    @Override
    public BankResponse creditAccountTransaction(CreditDebitRequest creditRequest) {
        boolean accountExists = customerRepository.existsByAccountNumber(creditRequest.getAccountNumber());
        if (!accountExists) {
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_DOES_NOT_EXIST_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_DOES_NOT_EXIST_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }


        Customer accountToCredit = customerRepository.findByAccountNumber(creditRequest.getAccountNumber());
        accountToCredit.setAccountBalance(accountToCredit.getAccountBalance().add(creditRequest.getAmount()));
        customerRepository.save(accountToCredit);
        return BankResponse.builder()
                .responseCode(ApiResponses.ACCOUNT_CREDITED_CODE)
                .responseMessage(ApiResponses.ACCOUNT_CREDITED_MESSAGE)
                .customerAccountInfo(CustomerAccountInfo.builder()
                        .accountName(accountToCredit.getFirstName() + " " + accountToCredit.getLastName())
                        .accountBalance(accountToCredit.getAccountBalance())
                        .accountNumber(creditRequest.getAccountNumber())
                        .build())
                .build();
    }

    @Override
    public BankResponse debitAccountTransaction(CreditDebitRequest debitRequest) {
        boolean accountExists = customerRepository.existsByAccountNumber(debitRequest.getAccountNumber());
        if (!accountExists) {
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_DOES_NOT_EXIST_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_DOES_NOT_EXIST_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }

        Customer accountToDebit = customerRepository.findByAccountNumber(debitRequest.getAccountNumber());
        BigDecimal availableBalance = accountToDebit.getAccountBalance();
        BigDecimal debitAmount = debitRequest.getAmount();
        // accountToDebit.setAccountBalance(accountToDebit.getAccountBalance().subtract(debitRequest.getAmount()));
        int result = availableBalance.compareTo(debitAmount);
        if (result < 0) {
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_HAS_INSUFFICIENT_FUNDS_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_HAS_INSUFFICIENT_FUNDS_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        } else {
            accountToDebit.setAccountBalance(accountToDebit.getAccountBalance().subtract(debitRequest.getAmount()));
            customerRepository.save(accountToDebit);
            return BankResponse.builder()
                    .responseCode(ApiResponses.ACCOUNT_DEBITED_CODE)
                    .responseMessage(ApiResponses.ACCOUNT_DEBITED_MESSAGE)
                    .customerAccountInfo(CustomerAccountInfo.builder()
                            .accountName(accountToDebit.getFirstName() + " " + accountToDebit.getLastName())
                            .accountBalance(accountToDebit.getAccountBalance())
                            .accountNumber(debitRequest.getAccountNumber())
                            .build())
                    .build();
        }
    }
}
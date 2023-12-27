package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.*;
import com.bankofjava.javabank.entity.Customer;
import com.bankofjava.javabank.repository.CustomerRepository;
import com.bankofjava.javabank.utils.AccountUtils;
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
                    .responseCode(AccountUtils.ACCOUNT_ALREADY_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_ALREADY_EXISTS_MESSAGE)
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
        return BankResponse.builder().responseCode(AccountUtils.ACCOUNT_CREATED_CODE).responseMessage(AccountUtils.ACCOUNT_CREATED_MESSAGE)
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
                    .responseCode(AccountUtils.ACCOUNT_DOES_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_DOES_NOT_EXIST_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }

        Customer requestedCustomer = customerRepository.findByAccountNumber(balanceRequest.getAccountNumber());
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
                .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
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
            return AccountUtils.ACCOUNT_DOES_NOT_EXIST_MESSAGE;
        }
        Customer requestedCustomer = customerRepository.findByAccountNumber(nameRequest.getAccountNumber());
        return requestedCustomer.getFirstName() + " " + requestedCustomer.getLastName();
    }


    @Override
    public BankResponse creditAccountTransaction(CreditDebitRequest creditRequest) {
        boolean accountExists = customerRepository.existsByAccountNumber(creditRequest.getAccountNumber());
        if (!accountExists) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_DOES_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_DOES_NOT_EXIST_MESSAGE)
                    .customerAccountInfo(null)
                    .build();
        }


        Customer accountToCredit = customerRepository.findByAccountNumber(creditRequest.getAccountNumber());
        accountToCredit.setAccountBalance(accountToCredit.getAccountBalance().add(creditRequest.getAmount()));
        customerRepository.save(accountToCredit);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREDITED_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREDITED_MESSAGE)
                .customerAccountInfo(CustomerAccountInfo.builder()
                        .accountName(accountToCredit.getFirstName() + " " + accountToCredit.getLastName())
                        .accountBalance(accountToCredit.getAccountBalance())
                        .accountNumber(creditRequest.getAccountNumber())
                        .build())
                .build();
    }
}
package com.bankofjava.javabank.service.impl;

import com.bankofjava.javabank.dto.CustomerAccountInfo;
import com.bankofjava.javabank.dto.CustomerRequest;
import com.bankofjava.javabank.dto.CustomerResponse;
import com.bankofjava.javabank.entity.Customer;
import com.bankofjava.javabank.repository.CustomerRepository;
import com.bankofjava.javabank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponse createAccount(CustomerRequest customerRequest) {
        if (customerRepository.existsByEmail(customerRequest.getEmail())){
          return CustomerResponse.builder()
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
        return CustomerResponse.builder().responseCode(AccountUtils.ACCOUNT_CREATED_CODE).responseMessage(AccountUtils.ACCOUNT_CREATED_MESSAGE)
                .customerAccountInfo(CustomerAccountInfo.builder()
                        .accountBalance(savedCustomer.getAccountBalance())
                        .accountNumber(savedCustomer.getAccountNumber())
                        .accountName(savedCustomer.getFirstName() + " " + savedCustomer.getLastName() + " " + savedCustomer.getOtherName())
                        .build())
                .build();
    }
}
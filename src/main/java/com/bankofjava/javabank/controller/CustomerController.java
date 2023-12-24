package com.bankofjava.javabank.controller;

import com.bankofjava.javabank.dto.CustomerRequest;
import com.bankofjava.javabank.dto.CustomerResponse;
import com.bankofjava.javabank.service.impl.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
    @Autowired
    CustomerDetailsService customerDetailsService;
    @PostMapping
    public CustomerResponse createAccount(@RequestBody CustomerRequest customerRequest) {
        return customerDetailsService.createAccount(customerRequest);
    }

}

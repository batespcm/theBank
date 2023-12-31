package com.bankofjava.javabank.utils;

import com.bankofjava.javabank.entity.Customer;
import com.bankofjava.javabank.repository.CustomerRepository;

import java.time.LocalDate;
import java.time.Year;

public class AccountUtils {
    CustomerRepository customerRepository;

    public static String createAccountNumber() {
        Year currentYear = Year.now();

        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();

        int min = 100000;
        int max = 999999;

        int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        String year = String.valueOf(currentYear);
        String month = String.valueOf(currentMonth);
        String randNumber = String.valueOf(randomNumber);
        return year + month + randNumber;
    }

    public static String getFullName(Customer customer) {
        String prefix = customer.getPrefix();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        return prefix + " " + firstName + " " + lastName;
    }
}

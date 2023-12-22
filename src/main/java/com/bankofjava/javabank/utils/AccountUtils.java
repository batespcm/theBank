package com.bankofjava.javabank.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class AccountUtils {


public static final String ACCOUNT_ALREADY_EXISTS_CODE = "0001";
public static final String ACCOUNT_ALREADY_EXISTS_MESSAGE = "This user already has an account on the system";
public static final String ACCOUNT_CREATED_CODE = "0002";
public static final String ACCOUNT_CREATED_MESSAGE = "Account successfully created";
    public static String createAccountNumber(){
        Year currentYear = Year.now();

        LocalDate today = LocalDate.now();
        Month currentMonth = Month.of(today.getMonth().getValue());

        int min = 100000;
        int max = 999999;

        int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        String year = String.valueOf(currentYear);
        String month = String.valueOf(currentMonth);
        String randNumber = String.valueOf(randomNumber);
        return year + month + randNumber;
    }

}

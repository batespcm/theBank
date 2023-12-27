package com.bankofjava.javabank.utils;

import java.time.LocalDate;
import java.time.Year;

public class AccountUtils {


    public static final String ACCOUNT_ALREADY_EXISTS_CODE = "0001";
    public static final String ACCOUNT_ALREADY_EXISTS_MESSAGE = "This user already has an account on the system";
    public static final String ACCOUNT_CREATED_CODE = "0002";
    public static final String ACCOUNT_CREATED_MESSAGE = "Account successfully created";
    public static final String ACCOUNT_DOES_NOT_EXIST_CODE = "0003";
    public static final String ACCOUNT_DOES_NOT_EXIST_MESSAGE = "Account does not exist";
    public static final String ACCOUNT_FOUND_CODE = "0004";
    public static final String ACCOUNT_FOUND_MESSAGE = "Account Found Successfully";
    public static final String ACCOUNT_CREDITED_CODE = "0005";
    public static final String ACCOUNT_CREDITED_MESSAGE = "Account Credited Successfully";
    public static final String ACCOUNT_DEBITED_CODE = "0006";
    public static final String ACCOUNT_DEBITED_MESSAGE = "Account Debited Successfully";

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

}

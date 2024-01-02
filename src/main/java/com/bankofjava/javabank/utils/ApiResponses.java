package com.bankofjava.javabank.utils;

public class ApiResponses {
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
    public static final String ACCOUNT_HAS_INSUFFICIENT_FUNDS_CODE = "0007";
    public static final String ACCOUNT_HAS_INSUFFICIENT_FUNDS_MESSAGE = "Account Has Insufficient Funds";
    public static final String PAYEE_ACCOUNT_DOES_NOT_EXIST_CODE = "0008";
    public static final String PAYEE_ACCOUNT_DOES_NOT_EXIST_MESSAGE = "Transfer Failed, Payee Account number is incorrect";
    public static final String RECIPIENT_ACCOUNT_DOES_NOT_EXIST_CODE = "0009";
    public static final String RECIPIENT_ACCOUNT_DOES_NOT_EXIST_MESSAGE = "Transfer Failed, Recipient Account number is incorrect";
    public static final String PAYEE_ACCOUNT_HAS_INSUFFICIENT_FUNDS_CODE = "0010";
    public static final String PAYEE_ACCOUNT_HAS_INSUFFICIENT_FUNDS_MESSAGE = "Payee Account has insufficient funds to complete the transfer";
    public static final String FINANCIAL_TRANSFER_SUCCESS_CODE = "0011";
    public static final String FINANCIAL_TRANSFER_SUCCESS_MESSAGE = "Account Monetary Transfer Successful";
}

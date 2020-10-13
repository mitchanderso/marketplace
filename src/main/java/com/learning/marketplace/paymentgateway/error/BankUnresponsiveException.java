package com.learning.marketplace.paymentgateway.error;

public class BankUnresponsiveException extends RuntimeException {
    public BankUnresponsiveException(String message) {
        super(message);
    }
}

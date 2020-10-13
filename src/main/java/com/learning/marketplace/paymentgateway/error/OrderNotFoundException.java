package com.learning.marketplace.paymentgateway.error;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("No order with " + id + " found");
    }


}

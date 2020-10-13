package com.learning.marketplace.error;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("No order with " + id + " found");
    }


}

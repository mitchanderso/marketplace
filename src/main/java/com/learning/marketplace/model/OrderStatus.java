package com.learning.marketplace.model;

public enum OrderStatus {
    SUCCESS("success"),
    FAIL("fail"),
    IN_PROGRESS("in_progress");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

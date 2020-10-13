package com.learning.marketplace.paymentgateway.model;

public class OrderResponse {

    private String cardNumber;
    private String expiryDate;
    private OrderStatus orderStatus;

    public OrderResponse() {
    }

    public OrderResponse(String cardNumber, OrderStatus orderStatus, String expiryDate) {
        this.cardNumber = cardNumber;
        this.orderStatus = orderStatus;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}

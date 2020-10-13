package com.learning.marketplace.paymentgateway.model;

public class NewOrderRequest {
    private String cvv;
    private String cardNumber;
    private String currency;
    private String expiryDate;
    private String amount;

    public NewOrderRequest(String cvv, String cardNumber, String currency, String expiryDate, String amount) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.currency = currency;
        this.expiryDate = expiryDate;
        this.amount = amount;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

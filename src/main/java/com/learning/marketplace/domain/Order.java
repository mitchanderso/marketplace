package com.learning.marketplace.domain;

import javax.persistence.Entity;

@Entity
public class Order {
    private String cvv;
    private String cardNumber;
    private String expiryDate;
    private String currency;
    private String amount;

    public Order() {
    }

    public Order(String cvv, String cardNumber, String expiryDate, String currency, String amount) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.currency = currency;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
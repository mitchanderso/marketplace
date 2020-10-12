package com.learning.marketplace.domain;

import com.learning.marketplace.model.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {

    private String cvv;
    private String cardNumber;
    private String expiryDate;
    private String currency;
    private String amount;
    private OrderStatus orderStatus;

    @Id
    private String id;

    public Order() {
    }

    public Order(String cvv, String cardNumber, String expiryDate, String currency, String amount, String id) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.currency = currency;
        this.amount = amount;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}

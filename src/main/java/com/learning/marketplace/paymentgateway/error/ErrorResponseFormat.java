package com.learning.marketplace.paymentgateway.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponseFormat {
    String message;
    LocalDateTime timestamp;
    HttpStatus statusCode;

    public ErrorResponseFormat(String message, LocalDateTime timestamp, HttpStatus statusCode) {
        this.message = message;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}

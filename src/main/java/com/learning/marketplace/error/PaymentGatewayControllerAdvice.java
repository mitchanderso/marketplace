package com.learning.marketplace.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaymentGatewayControllerAdvice {
    @ResponseBody // This will be returned in the response body
    @ExceptionHandler(OrderNotFoundException.class) // It handles this specific exception
    @ResponseStatus(HttpStatus.NOT_FOUND) // And returns NOT_FOUND as the status
    String orderNotFoundException(OrderNotFoundException ex) {
        return ex.getMessage();
    }
}

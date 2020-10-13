package com.learning.marketplace.paymentgateway.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class PaymentGatewayControllerAdvice {
    @ResponseBody // This will be returned in the response body
    @ExceptionHandler(OrderNotFoundException.class) // It handles this specific exception
    @ResponseStatus(HttpStatus.NOT_FOUND) // And returns NOT_FOUND as the status
    ErrorResponseFormat orderNotFoundException(OrderNotFoundException ex) {
        return new ErrorResponseFormat(ex.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND);
    }

    @ResponseBody // This will be returned in the response body
    @ExceptionHandler(BankUnresponsiveException.class) // It handles this specific exception
    @ResponseStatus(HttpStatus.BAD_GATEWAY) // And returns NOT_FOUND as the status
    ErrorResponseFormat bankUnresponseive(BankUnresponsiveException ex) {
        return new ErrorResponseFormat(ex.getMessage(), LocalDateTime.now(), HttpStatus.BAD_GATEWAY);
    }
}

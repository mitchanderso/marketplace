package com.learning.marketplace.paymentgateway.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.marketplace.paymentgateway.domain.Order;
import com.learning.marketplace.paymentgateway.error.ErrorResponseFormat;
import com.learning.marketplace.paymentgateway.error.OrderNotFoundException;
import com.learning.marketplace.paymentgateway.model.NewOrderRequest;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.model.OrderStatus;
import com.learning.marketplace.paymentgateway.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentGatewayController.class)
class PaymentGatewayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;

    @MockBean
    private RestTemplateBuilder restTemplateBuilder;


    @Test
    void getOrderById() throws Exception {
        OrderResponse expected = new OrderResponse("12345", OrderStatus.SUCCESS, "05/25");
        when(orderService.getOrderById(any())).thenReturn(expected);
        String actual = mockMvc.perform(get("/order/{id}", "ORD-001"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(objectMapper.readValue(actual, OrderResponse.class)).isEqualToComparingFieldByField(expected);
    }

    @Test
    void when_orderDoesntExistReturnException() throws Exception {
        when(orderService.getOrderById(any())).thenThrow(new OrderNotFoundException("ORD-001"));
        ErrorResponseFormat expected = new ErrorResponseFormat("No order with ORD-001 found", LocalDateTime.now(), HttpStatus.NOT_FOUND);
        String actual = mockMvc.perform(get("/order/{id}", "ORD-001"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();
        ErrorResponseFormat actualFormatted = objectMapper.readValue(actual, ErrorResponseFormat.class);
        assertThat(actualFormatted).isEqualToComparingOnlyGivenFields(expected, "message", "statusCode");

    }

    @Test
    void createOrder() throws Exception {
        Order order = new Order("123", "123456789", "05/25", "AUD", "AMOUNT", "ORD-001");
        NewOrderRequest newOrderRequest = new NewOrderRequest("123", "123456789", "05/25", "AUD", "AMOUNT");
        when(orderService.save(any())).thenReturn(order);
        String actual = mockMvc.perform(post("/order", "ORD-001")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(newOrderRequest)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Order actualOrder = objectMapper.readValue(actual, Order.class);
        assertThat(actualOrder).isEqualToComparingFieldByField(order);
    }
}
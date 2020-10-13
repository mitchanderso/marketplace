package com.learning.marketplace.paymentgateway.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.model.OrderStatus;
import com.learning.marketplace.paymentgateway.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void whenValidInputReturn200() {

    }

    @Test
    void getOrderById() throws Exception {
        OrderResponse expected = new OrderResponse("12345", OrderStatus.SUCCESS, "05/25");
        when(orderService.getOrderById(any())).thenReturn(expected);
        String actual = mockMvc.perform(get("/order/{id}", "ORD-001"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(expected).isEqualToComparingFieldByField(objectMapper.readValue(actual, OrderResponse.class));
    }

}
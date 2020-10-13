package com.learning.marketplace.paymentgateway.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.marketplace.paymentgateway.model.NewOrderRequest;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.repository.OrderRepository;
import com.learning.marketplace.paymentgateway.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebMvcTest
public class FullIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void createOrderIntegrationTest() throws Exception {
        NewOrderRequest newOrderRequest = new NewOrderRequest("123", "123456789", "05/25", "AUD", "AMOUNT");
        mockMvc.perform(post("/order", "ORD-001")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(newOrderRequest)))
                .andExpect(status().isOk());

        OrderResponse orderResponse = orderService.getOrderById("ORD-001");
        assertThat(orderResponse).isNotNull();
    }
}

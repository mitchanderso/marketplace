package com.learning.marketplace.paymentgateway.services;

import com.learning.marketplace.paymentgateway.domain.Order;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.model.OrderStatus;
import com.learning.marketplace.paymentgateway.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Mock
    RestTemplate restTemplate;

    @Test
    void when_orderWithRealIdReturnOrderResponse() {
        Order order = new Order("123", "123456789", "05/25", "AUD", "AMOUNT", "ORD-001");
        order.setOrderStatus(OrderStatus.SUCCESS);
        when(orderRepository.findById(any())).thenReturn(Optional.of(order));
        OrderResponse expected = new OrderResponse("XXXXXX789", OrderStatus.SUCCESS, "05/25");
        OrderResponse actual = orderService.getOrderById("ORD-001");
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

}
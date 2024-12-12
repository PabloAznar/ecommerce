package com.example.ecommerce.order.application.create;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.order.domain.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderCreator {

    private final OrderRepository orderRepository;

    public OrderCreator(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        order.setCreationDate(LocalDateTime.now());
        orderRepository.save(order);
    }

}

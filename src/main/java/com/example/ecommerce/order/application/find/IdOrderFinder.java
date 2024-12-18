package com.example.ecommerce.order.application.find;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.order.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class IdOrderFinder {

    private final OrderRepository orderRepository;

    public IdOrderFinder(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(final String id) {
        return orderRepository.findById(id);
    }

}

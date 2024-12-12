package com.example.ecommerce.order.application.add;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.order.domain.OrderRepository;
import com.example.ecommerce.order.domain.dto.ProductOrderDto;
import com.example.ecommerce.product.shared.ProductCreatorComponent;
import org.springframework.stereotype.Service;

@Service
public class OrderProductAdder {

    private final OrderRepository orderRepository;

    public OrderProductAdder(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(final ProductOrderDto productOrder) {
        Order order = orderRepository.findById(productOrder.getOrderId());
        order.addProduct(ProductCreatorComponent.crate(productOrder.getProductId()));
        orderRepository.save(order);
    }

}

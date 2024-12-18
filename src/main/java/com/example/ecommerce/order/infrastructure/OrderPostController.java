package com.example.ecommerce.order.infrastructure;

import com.example.ecommerce.order.application.create.OrderCreator;
import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.shared.domain.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPostController {

    private final OrderCreator orderCreator;

    public OrderPostController(OrderCreator orderCreator) {
        this.orderCreator = orderCreator;
    }

    @PostMapping(value = Constants.API_BASE_PATH + "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductToOrder(@RequestBody Order order) {
        orderCreator.create(order);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

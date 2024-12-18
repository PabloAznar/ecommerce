package com.example.ecommerce.order.infrastructure;

import com.example.ecommerce.order.application.find.IdOrderFinder;
import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.shared.domain.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderGetController {

    private final IdOrderFinder orderFinder;

    public OrderGetController(final IdOrderFinder orderFinder) {
        this.orderFinder = orderFinder;
    }

    @GetMapping(path = Constants.API_BASE_PATH + "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findById(@PathVariable final String id) {
        return orderFinder.findById(id);
    }

}

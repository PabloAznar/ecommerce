package com.example.ecommerce.order.infrastructure;

import com.example.ecommerce.order.application.add.OrderProductAdder;
import com.example.ecommerce.order.domain.dto.ProductOrderDto;
import com.example.ecommerce.shared.domain.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPutController {

    private final OrderProductAdder orderProductAdder;

    public OrderPutController(OrderProductAdder orderProductAdder) {
        this.orderProductAdder = orderProductAdder;
    }

    @PutMapping(value = Constants.API_BASE_PATH + "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductToOrder( @RequestBody ProductOrderDto productOrder) {
        orderProductAdder.add(productOrder);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

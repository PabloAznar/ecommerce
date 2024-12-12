package com.example.ecommerce.order.domain.dto;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.product.domain.Product;
import lombok.Data;

@Data
public class ProductOrderDto {

    private String orderId;

    private String productId;

}

package com.example.ecommerce.product.shared;

import com.example.ecommerce.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatorComponent {

    public static Product crate(final String id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }
}

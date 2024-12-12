package com.example.ecommerce.product.infrastructure;

import com.example.ecommerce.product.application.find.ProductIdFinder;
import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.shared.domain.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductGetController {

    private final ProductIdFinder productFinder;

    public ProductGetController(final ProductIdFinder productFinder) {
        this.productFinder = productFinder;
    }

    @GetMapping(Constants.API_BASE_PATH + "/products/{id}")
    public Product findById(@PathVariable("id") final String id) {
        return productFinder.find(id);
    }

}

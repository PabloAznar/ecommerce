package com.example.ecommerce.shoppingcart.application.creator;

import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import com.example.ecommerce.shoppingcart.domain.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartCreator {

    private final ShoppingCartRepository shoppingCartRepository;


    public ShoppingCartCreator(final ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void create(ShoppingCart shoppingCart) {
        this.shoppingCartRepository.create(shoppingCart);
    }
}

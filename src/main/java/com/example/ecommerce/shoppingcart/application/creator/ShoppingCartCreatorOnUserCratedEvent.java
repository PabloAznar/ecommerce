package com.example.ecommerce.shoppingcart.application.creator;

import com.example.ecommerce.shared.user.domain.UserCreatedEvent;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartCreatorOnUserCratedEvent {

    private final ShoppingCartCreator shoppingCartCreator;

    public ShoppingCartCreatorOnUserCratedEvent(final ShoppingCartCreator shoppingCartCreator) {
        this.shoppingCartCreator = shoppingCartCreator;
    }

    @EventListener
    public void on(UserCreatedEvent event) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(event.getUser());
        shoppingCartCreator.create(shoppingCart);
    }

}

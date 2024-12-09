package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.ShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class ShoppingCartRepository extends Repository<String, ShoppingCart> {

    public ShoppingCartRepository(SessionFactory sessionFactory) {
        super(sessionFactory, ShoppingCart.class);
    }

}

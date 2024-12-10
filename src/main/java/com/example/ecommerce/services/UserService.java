package com.example.ecommerce.services;

import com.example.ecommerce.entities.ShoppingCart;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.exceptions.ECommerceException;
import com.example.ecommerce.exceptions.ExceptionType;
import com.example.ecommerce.repositories.Criteria;
import com.example.ecommerce.repositories.Filter;
import com.example.ecommerce.repositories.ShoppingCartRepository;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final ShoppingCartRepository shoppingCartRepository;

    public UserService(final UserRepository userRepository, final ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public User findById(final String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ECommerceException(ExceptionType.USER_NOT_FOUND));
    }

    public void createUser(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartRepository.save(shoppingCart);
        user.setShoppingCart(shoppingCart);
        this.userRepository.save(user);
    }

    public List<User> findByCriteria(final Criteria criteria) {
        return userRepository.findByCriteria(criteria);
    }
}

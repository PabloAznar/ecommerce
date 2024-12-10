package com.example.ecommerce.shoppingcart.application.finder;

import com.example.ecommerce.shared.domain.Criteria;
import com.example.ecommerce.shared.domain.Filter;
import com.example.ecommerce.shared.domain.OperationFilter;
import com.example.ecommerce.shoppingcart.domain.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class UserShoppingCartFinder {

    private final ShoppingCartRepository shoppingCartRepository;

    public UserShoppingCartFinder(final ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void find(String userId) {
        Filter searchByUserIdFilter = new Filter("user_id", OperationFilter.EQUALS.getOperation(), userId);
        Criteria criteria = new Criteria();
        criteria.addFilter(searchByUserIdFilter);
        this.shoppingCartRepository.findByCriteria(criteria);
    }
}

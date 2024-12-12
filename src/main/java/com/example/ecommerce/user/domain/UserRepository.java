package com.example.ecommerce.user.domain;

import com.example.ecommerce.shared.domain.criteria.Criteria;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(String id);

    List<User> findByCriteria(Criteria criteria);
}

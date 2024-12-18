package com.example.ecommerce.user.domain;

import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.payment.Payment;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(String id);

    List<User> findByCriteria(Criteria criteria);

    List<Address> findAddressesByUser(String userId);

    List<Payment> findPaymentsByUser(String userId);
}

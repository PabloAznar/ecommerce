package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class UserRepository extends Repository<String, User>{

    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    //TODO
    @Override
    public User findByCriteria() {
        return null;
    }
}

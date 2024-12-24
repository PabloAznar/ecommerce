package com.example.ecommerce.user.infrastructure.persistance;

import com.example.ecommerce.shared.aspects.domain.AspectException;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.payment.Payment;
import com.example.ecommerce.user.domain.vo.UserId;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostgresUserRepository extends HibernateRepository<UserId, User> implements UserRepository {


    public PostgresUserRepository(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    @AspectException
    public User findById(String id) {
        return byId(new UserId(id))
                .orElseThrow(() ->
                        new ECommerceException(HttpStatus.NOT_FOUND, String.format("User with id %s not found", id)));
    }

    @Override
    public List<User> findByCriteria(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public List<Address> findAddressesByUser(String userId) {
        return sessionFactory.getCurrentSession().createQuery("select user.addresses from User user where user.id = ?1", Address.class)
                .setParameter(1, userId)
                .getResultList();
    }

    @Override
    public List<Payment> findPaymentsByUser(String userId) {
        return sessionFactory.getCurrentSession().createQuery("select user.payments from User user where user.id = ?1", Payment.class)
                .setParameter(1, userId)
                .getResultList();
    }

}

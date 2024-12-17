package com.example.ecommerce.user.infrastructure;

import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ExceptionType;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostgresUserRepository extends HibernateRepository<String, User> implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresUserRepository.class);

    public PostgresUserRepository(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public User findById(String id) {
        return byId(id)
                .orElseThrow(() -> {
                    LOGGER.error("User with id {} not found", id);
                    return new ECommerceException(ExceptionType.USER_NOT_FOUND);
                });
    }

    @Override
    public List<User> findByCriteria(Criteria criteria) {
        return byCriteria(criteria);
    }


}

package com.example.ecommerce.repositories;

import org.hibernate.SessionFactory;

import java.util.Optional;

public abstract class Repository<T, K>{

    protected SessionFactory sessionFactory;

    protected Class<K> classType;

    Repository(SessionFactory sessionFactory, Class<K> classType) {
        this.sessionFactory = sessionFactory;
        this.classType = classType;
    }

    public Optional<K> findById(T id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(classType).load(id));
    }

    public void save(K entity) {
        sessionFactory.getCurrentSession().persist(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    public abstract K findByCriteria();

}

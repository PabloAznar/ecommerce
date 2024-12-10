package com.example.ecommerce.shared.infrastructure;

import com.example.ecommerce.shared.domain.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T, K>{

    protected SessionFactory sessionFactory;
    protected final CriteriaConverter<K> criteriaConverter;

    protected Class<K> classType;

    public HibernateRepository(SessionFactory sessionFactory, Class<K> classType) {
        this.sessionFactory = sessionFactory;
        this.classType = classType;
        this.criteriaConverter = new CriteriaConverter<>(sessionFactory.getCriteriaBuilder());
    }

    public Optional<K> byId(T id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(classType).load(id));
    }

    public void save(K entity) {
        sessionFactory.getCurrentSession().persist(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    public List<K> byCriteria(Criteria criteria) {
       return sessionFactory.getCurrentSession().createQuery(criteriaConverter.convert(criteria, classType))
               .getResultList();
    }

}

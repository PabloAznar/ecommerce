package com.example.ecommerce.user.infrastructure.address;

import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.adress.AddressRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AddressPostgresRepository extends HibernateRepository<String, Address> implements AddressRepository {
    public AddressPostgresRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public List<Address> findByUserId(String userId) {
        return sessionFactory.getCurrentSession().createQuery("from Address address where address.user.id = ?1", Address.class)
                .setParameter(1, userId)
                .getResultList();
    }
}

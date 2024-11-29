package com.example.ecommerce.repositories;

public interface Repository<T, K>{

    public K findById(T id);

    public K save(K entity);

}

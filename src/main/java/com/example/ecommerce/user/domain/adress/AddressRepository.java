package com.example.ecommerce.user.domain.adress;

import java.util.List;

public interface AddressRepository {

    List<Address> findByUserId(String userId);

}

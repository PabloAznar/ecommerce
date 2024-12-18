package com.example.ecommerce.user.infrastructure.mapper;

import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.adress.dto.AddressDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    List<AddressDto> toDtos(List<Address> addresses);

    AddressDto toDto(Address address);
}

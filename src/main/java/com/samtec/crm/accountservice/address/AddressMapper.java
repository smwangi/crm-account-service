package com.samtec.crm.accountservice.address;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto);
    List<AddressDto> addressDtoList(List<Address> addressList);
}

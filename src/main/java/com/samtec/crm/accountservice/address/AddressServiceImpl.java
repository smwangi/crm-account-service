
package com.samtec.crm.accountservice.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressServiceImpl  implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper mapper;

    @Override
    public AddressDto save(AddressDto addressDto) {
        return mapper.toAddressDto(addressRepository.save(mapper.toAddress(addressDto)));
    }

    @Override
    public Optional<AddressDto> findById(long id) {
        return Optional.of(mapper.toAddressDto(addressRepository.findById(id).get()));
    }

    @Override
    public List<AddressDto> fetchAll() {
        return mapper.addressDtoList(addressRepository.findAll());
    }

    //@Override
    public AddressDto update(AddressDto addressDto) {
        return mapper.toAddressDto(addressRepository.save(mapper.toAddress(addressDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

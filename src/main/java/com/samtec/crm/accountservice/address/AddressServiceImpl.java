
package com.samtec.crm.accountservice.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return addressRepository.findById(id)
                .stream()
                .map(mapper::toAddressDto)
                .findFirst();
    }

    @Override
    public List<AddressDto> fetchAll() {
        return addressRepository.findAll()
                .stream()
                .map(mapper::toAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

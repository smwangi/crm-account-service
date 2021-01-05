package com.samtec.crm.accountservice.address;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-05T22:04:56+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setBoxAddress( address.getBoxAddress() );
        addressDto.setEmail( address.getEmail() );
        addressDto.setMobilePhone( address.getMobilePhone() );
        addressDto.setPhone( address.getPhone() );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setWebsite( address.getWebsite() );
        if ( address.getModifiedAt() != null ) {
            addressDto.setModifiedAt( LocalDateTime.ofInstant( address.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return addressDto;
    }

    @Override
    public Address toAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        if ( addressDto.getModifiedAt() != null ) {
            address.setModifiedAt( Date.from( addressDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        address.setWebsite( addressDto.getWebsite() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );
        address.setMobilePhone( addressDto.getMobilePhone() );
        address.setEmail( addressDto.getEmail() );
        address.setBoxAddress( addressDto.getBoxAddress() );

        return address;
    }

    @Override
    public List<AddressDto> addressDtoList(List<Address> addressList) {
        if ( addressList == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toAddressDto( address ) );
        }

        return list;
    }
}

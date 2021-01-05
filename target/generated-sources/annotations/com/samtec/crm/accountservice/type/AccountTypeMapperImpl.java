package com.samtec.crm.accountservice.type;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-20T16:56:04+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
@Component
public class AccountTypeMapperImpl implements AccountTypeMapper {

    @Override
    public AccountTypeDto toAccountTypeDto(AccountType accountType) {
        if ( accountType == null ) {
            return null;
        }

        AccountTypeDto accountTypeDto = new AccountTypeDto();

        accountTypeDto.setName( accountType.getName() );
        accountTypeDto.setDescription( accountType.getDescription() );

        return accountTypeDto;
    }

    @Override
    public AccountType toAccountType(AccountTypeDto accountTypeDto) {
        if ( accountTypeDto == null ) {
            return null;
        }

        AccountType accountType = new AccountType();

        accountType.setName( accountTypeDto.getName() );
        accountType.setDescription( accountTypeDto.getDescription() );

        return accountType;
    }

    @Override
    public List<AccountTypeDto> toAccountTypeDtoList(List<AccountType> accountTypeList) {
        if ( accountTypeList == null ) {
            return null;
        }

        List<AccountTypeDto> list = new ArrayList<AccountTypeDto>( accountTypeList.size() );
        for ( AccountType accountType : accountTypeList ) {
            list.add( toAccountTypeDto( accountType ) );
        }

        return list;
    }

    @Override
    public List<AccountType> toAccountTypeList(List<AccountTypeDto> accountTypeDtoList) {
        if ( accountTypeDtoList == null ) {
            return null;
        }

        List<AccountType> list = new ArrayList<AccountType>( accountTypeDtoList.size() );
        for ( AccountTypeDto accountTypeDto : accountTypeDtoList ) {
            list.add( toAccountType( accountTypeDto ) );
        }

        return list;
    }
}

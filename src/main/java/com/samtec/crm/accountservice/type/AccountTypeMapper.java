
package com.samtec.crm.accountservice.type;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {
    AccountTypeDto toAccountTypeDto(AccountType accountType);
    AccountType toAccountType(AccountTypeDto accountTypeDto);
    List<AccountTypeDto> toAccountTypeDtoList(List<AccountType>accountTypeList);
    List<AccountType> toAccountTypeList(List<AccountTypeDto>accountTypeDtoList);
}

package com.samtec.crm.accountservice.update;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountUpdateMapper {

    AccountUpdateDto toAccountUpdateDto(AccountUpdate accountUpdate);
    AccountUpdate toAccountUpdate(AccountUpdateDto accountUpdateDto);
    List<AccountUpdateDto> toAccountUpdateDtoList(List<AccountUpdate> accountUpdateList);
}
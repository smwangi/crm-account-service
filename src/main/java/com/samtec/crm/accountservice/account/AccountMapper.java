package com.samtec.crm.accountservice.account;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toAccountDto(Account account);
    Account toAccount(AccountDto accountDto);
    List<AccountDto> accountDtoList(List<Account> accountList);
}

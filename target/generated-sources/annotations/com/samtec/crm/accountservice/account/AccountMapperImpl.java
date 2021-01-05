package com.samtec.crm.accountservice.account;

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
    date = "2020-12-20T16:56:04+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setName( account.getName() );
        if ( account.getModifiedAt() != null ) {
            accountDto.setModifiedAt( LocalDateTime.ofInstant( account.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return accountDto;
    }

    @Override
    public Account toAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDto.getId() );
        if ( accountDto.getModifiedAt() != null ) {
            account.setModifiedAt( Date.from( accountDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        account.setName( accountDto.getName() );

        return account;
    }

    @Override
    public List<AccountDto> accountDtoList(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( toAccountDto( account ) );
        }

        return list;
    }
}

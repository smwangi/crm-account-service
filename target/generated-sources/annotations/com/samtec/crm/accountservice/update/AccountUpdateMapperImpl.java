package com.samtec.crm.accountservice.update;

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
public class AccountUpdateMapperImpl implements AccountUpdateMapper {

    @Override
    public AccountUpdateDto toAccountUpdateDto(AccountUpdate accountUpdate) {
        if ( accountUpdate == null ) {
            return null;
        }

        AccountUpdateDto accountUpdateDto = new AccountUpdateDto();

        accountUpdateDto.setSubject( accountUpdate.getSubject() );
        accountUpdateDto.setNextActionDate( accountUpdate.getNextActionDate() );
        accountUpdateDto.setNextAction( accountUpdate.getNextAction() );
        accountUpdateDto.setDate( accountUpdate.getDate() );
        accountUpdateDto.setDescription( accountUpdate.getDescription() );
        if ( accountUpdate.getModifiedAt() != null ) {
            accountUpdateDto.setModifiedAt( LocalDateTime.ofInstant( accountUpdate.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        accountUpdateDto.setModifiedBy( accountUpdate.getModifiedBy() );

        return accountUpdateDto;
    }

    @Override
    public AccountUpdate toAccountUpdate(AccountUpdateDto accountUpdateDto) {
        if ( accountUpdateDto == null ) {
            return null;
        }

        AccountUpdate accountUpdate = new AccountUpdate();

        accountUpdate.setId( accountUpdateDto.getId() );
        if ( accountUpdateDto.getModifiedAt() != null ) {
            accountUpdate.setModifiedAt( Date.from( accountUpdateDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        accountUpdate.setDescription( accountUpdateDto.getDescription() );
        accountUpdate.setDate( accountUpdateDto.getDate() );
        accountUpdate.setNextActionDate( accountUpdateDto.getNextActionDate() );
        accountUpdate.setSubject( accountUpdateDto.getSubject() );
        accountUpdate.setNextAction( accountUpdateDto.getNextAction() );
        if ( accountUpdateDto.getModifiedBy() != null ) {
            accountUpdate.setModifiedBy( accountUpdateDto.getModifiedBy() );
        }

        return accountUpdate;
    }

    @Override
    public List<AccountUpdateDto> toAccountUpdateDtoList(List<AccountUpdate> accountUpdateList) {
        if ( accountUpdateList == null ) {
            return null;
        }

        List<AccountUpdateDto> list = new ArrayList<AccountUpdateDto>( accountUpdateList.size() );
        for ( AccountUpdate accountUpdate : accountUpdateList ) {
            list.add( toAccountUpdateDto( accountUpdate ) );
        }

        return list;
    }
}

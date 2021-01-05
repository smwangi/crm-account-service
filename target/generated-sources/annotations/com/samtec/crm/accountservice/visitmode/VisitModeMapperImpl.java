package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.visit.Visit;
import com.samtec.crm.accountservice.visit.VisitDto;
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
public class VisitModeMapperImpl implements VisitModeMapper {

    @Override
    public VisitModeDto toVisitModeDto(VisitMode visitMode) {
        if ( visitMode == null ) {
            return null;
        }

        VisitModeDto visitModeDto = new VisitModeDto();

        visitModeDto.setName( visitMode.getName() );
        visitModeDto.setDescription( visitMode.getDescription() );
        visitModeDto.setId( visitMode.getId() );
        if ( visitMode.getModifiedAt() != null ) {
            visitModeDto.setModifiedAt( LocalDateTime.ofInstant( visitMode.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        visitModeDto.setModifiedBy( visitMode.getModifiedBy() );

        return visitModeDto;
    }

    @Override
    public VisitMode toVisitMode(VisitModeDto visitModeDto) {
        if ( visitModeDto == null ) {
            return null;
        }

        VisitMode visitMode = new VisitMode();

        visitMode.setId( visitModeDto.getId() );
        if ( visitModeDto.getModifiedAt() != null ) {
            visitMode.setModifiedAt( Date.from( visitModeDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        visitMode.setModifiedBy( visitModeDto.getModifiedBy() );
        visitMode.setName( visitModeDto.getName() );
        visitMode.setDescription( visitModeDto.getDescription() );

        return visitMode;
    }

    @Override
    public List<VisitModeDto> toVisitModeDtoList(List<VisitMode> visitModeList) {
        if ( visitModeList == null ) {
            return null;
        }

        List<VisitModeDto> list = new ArrayList<VisitModeDto>( visitModeList.size() );
        for ( VisitMode visitMode : visitModeList ) {
            list.add( toVisitModeDto( visitMode ) );
        }

        return list;
    }

    @Override
    public VisitDto map(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitDto visitDto = new VisitDto();

        if ( visit.getModifiedAt() != null ) {
            visitDto.setModifiedAt( LocalDateTime.ofInstant( visit.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        visitDto.setId( visit.getId() );
        visitDto.setModifiedBy( visit.getModifiedBy() );

        return visitDto;
    }

    @Override
    public Visit map(VisitDto visitDto) {
        if ( visitDto == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setId( visitDto.getId() );
        if ( visitDto.getModifiedAt() != null ) {
            visit.setModifiedAt( Date.from( visitDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( visitDto.getModifiedBy() != null ) {
            visit.setModifiedBy( visitDto.getModifiedBy() );
        }

        return visit;
    }
}

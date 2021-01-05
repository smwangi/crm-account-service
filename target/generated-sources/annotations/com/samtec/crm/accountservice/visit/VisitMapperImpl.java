package com.samtec.crm.accountservice.visit;

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
public class VisitMapperImpl implements VisitMapper {

    @Override
    public VisitDto toVisitDto(Visit visit) {
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
    public Visit toVisit(VisitDto visitDto) {
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

    @Override
    public List<VisitDto> visitDtoList(List<Visit> visitList) {
        if ( visitList == null ) {
            return null;
        }

        List<VisitDto> list = new ArrayList<VisitDto>( visitList.size() );
        for ( Visit visit : visitList ) {
            list.add( toVisitDto( visit ) );
        }

        return list;
    }
}

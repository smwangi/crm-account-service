package com.samtec.crm.accountservice.industry;

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
public class IndustryMapperImpl implements IndustryMapper {

    @Override
    public IndustryDto toIndustryDto(Industry industry) {
        if ( industry == null ) {
            return null;
        }

        IndustryDto industryDto = new IndustryDto();

        industryDto.setName( industry.getName() );
        industryDto.setDescription( industry.getDescription() );
        if ( industry.getModifiedAt() != null ) {
            industryDto.setModifiedAt( LocalDateTime.ofInstant( industry.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        industryDto.setId( industry.getId() );

        return industryDto;
    }

    @Override
    public Industry toIndustry(IndustryDto industryDto) {
        if ( industryDto == null ) {
            return null;
        }

        Industry industry = new Industry();

        industry.setId( industryDto.getId() );
        if ( industryDto.getModifiedAt() != null ) {
            industry.setModifiedAt( Date.from( industryDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        industry.setName( industryDto.getName() );
        industry.setDescription( industryDto.getDescription() );

        return industry;
    }

    @Override
    public List<IndustryDto> toIndustryDtoList(List<Industry> industryList) {
        if ( industryList == null ) {
            return null;
        }

        List<IndustryDto> list = new ArrayList<IndustryDto>( industryList.size() );
        for ( Industry industry : industryList ) {
            list.add( toIndustryDto( industry ) );
        }

        return list;
    }
}

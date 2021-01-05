package com.samtec.crm.accountservice.rating;

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
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingDto toRatingDto(Rating rating) {
        if ( rating == null ) {
            return null;
        }

        RatingDto ratingDto = new RatingDto();

        ratingDto.setName( rating.getName() );
        ratingDto.setDescription( rating.getDescription() );
        if ( rating.getModifiedAt() != null ) {
            ratingDto.setModifiedAt( LocalDateTime.ofInstant( rating.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return ratingDto;
    }

    @Override
    public Rating toRating(RatingDto ratingDto) {
        if ( ratingDto == null ) {
            return null;
        }

        Rating rating = new Rating();

        rating.setId( ratingDto.getId() );
        if ( ratingDto.getModifiedAt() != null ) {
            rating.setModifiedAt( Date.from( ratingDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }
        rating.setName( ratingDto.getName() );
        rating.setDescription( ratingDto.getDescription() );

        return rating;
    }

    @Override
    public List<RatingDto> toRatingDtoList(List<Rating> ratingList) {
        if ( ratingList == null ) {
            return null;
        }

        List<RatingDto> list = new ArrayList<RatingDto>( ratingList.size() );
        for ( Rating rating : ratingList ) {
            list.add( toRatingDto( rating ) );
        }

        return list;
    }
}

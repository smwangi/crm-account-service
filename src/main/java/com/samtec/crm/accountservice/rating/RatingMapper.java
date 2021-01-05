
package com.samtec.crm.accountservice.rating;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingDto toRatingDto(Rating rating);
    Rating toRating(RatingDto ratingDto);
}

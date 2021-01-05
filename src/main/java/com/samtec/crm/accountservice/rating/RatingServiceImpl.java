
package com.samtec.crm.accountservice.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired RatingMapper mapper;

    @Override
    public RatingDto save(RatingDto ratingDto) {
        return mapper.toRatingDto(ratingRepository.save(mapper.toRating(ratingDto)));
    }

    @Override
    public Optional<RatingDto> findById(long id) {
        return ratingRepository.findById(id)
                .stream()
                .map(mapper::toRatingDto)
                .findFirst();
    }

    @Override
    public List<RatingDto> fetchAll() {

        return ratingRepository.findAll()
                .stream()
                .map(mapper::toRatingDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

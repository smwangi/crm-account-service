package com.samtec.crm.accountservice.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(mapper.toRatingDto(ratingRepository.findById(id).get()));
    }

    @Override
    public List<RatingDto> fetchAll() {
        return mapper.toRatingDtoList(ratingRepository.findAll());
    }

    //@Override
    public RatingDto update(RatingDto ratingDto) {
        return mapper.toRatingDto(ratingRepository.save(mapper.toRating(ratingDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

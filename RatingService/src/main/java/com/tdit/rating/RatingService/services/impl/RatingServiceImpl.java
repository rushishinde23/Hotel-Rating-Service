package com.tdit.rating.RatingService.services.impl;

import com.tdit.rating.RatingService.entities.Rating;
import com.tdit.rating.RatingService.repositories.RatingRepository;
import com.tdit.rating.RatingService.services.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository=ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }
}

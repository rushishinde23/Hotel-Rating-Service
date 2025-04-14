package com.tdit.rating.RatingService.services;

import com.tdit.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getRatingByHotelId(String hotelId);
    List<Rating> getRatingByUserId(String userId);

}

package com.tdit.user.UserService.entities;

public class Rating {

    private String ratingId;
    private String hotelId;
    private String userId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;

    public Rating() {
    }

    public Rating(String ratingId, String hotelId, String userId, Integer rating, String feedback, Hotel hotel) {
        this.ratingId = ratingId;
        this.hotelId = hotelId;
        this.userId = userId;
        this.rating = rating;
        this.feedback = feedback;
        this.hotel = hotel;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId='" + ratingId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", userId='" + userId + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}

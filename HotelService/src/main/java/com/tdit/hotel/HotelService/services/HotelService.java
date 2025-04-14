package com.tdit.hotel.HotelService.services;

import com.tdit.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String hotelId);
    String updateHotel(Hotel hotel,String hotelId);
    String deleteHotel(String hotelId);

}

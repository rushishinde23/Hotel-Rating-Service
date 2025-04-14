package com.tdit.hotel.HotelService.services.impl;

import com.tdit.hotel.HotelService.entities.Hotel;
import com.tdit.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.tdit.hotel.HotelService.repositories.HotelRepository;
import com.tdit.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomId= UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        Hotel savedHotel=hotelRepository.save(hotel);
        return savedHotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels=hotelRepository.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        Hotel returnedHotel=hotelRepository.findById(hotelId).orElseThrow(()->(new ResourceNotFoundException("hotel is not found with id:"+hotelId)));
        return returnedHotel;
    }

    @Override
    public String updateHotel(Hotel hotel, String hotelId) {
        Hotel returnedHotel=hotelRepository.findById(hotelId).orElseThrow(()->(new ResourceNotFoundException("hotel is not found with id:"+hotelId)));
         returnedHotel.setHotelName(hotel.getHotelName());
         returnedHotel.setHotelLocation(hotel.getHotelLocation());
         returnedHotel.setAbout(hotel.getAbout());
         hotelRepository.save(returnedHotel);
        return "Hotel updated successfully";
    }

    @Override
    public String deleteHotel(String hotelId) {
        try{
           hotelRepository.deleteById(hotelId);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("hotel is not available with id:"+hotelId);
        }
        return "hotel deleted successfully";
    }
}

package com.tdit.hotel.HotelService.controllers;

import com.tdit.hotel.HotelService.entities.Hotel;
import com.tdit.hotel.HotelService.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

    private final HotelService hotelService;

    HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.getHotelById(hotelId));
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel,@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotel(hotel,hotelId));
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.deleteHotel(hotelId));
    }

}

package com.tdit.hotel.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    ResourceNotFoundException(){
        super("hotel not found");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}

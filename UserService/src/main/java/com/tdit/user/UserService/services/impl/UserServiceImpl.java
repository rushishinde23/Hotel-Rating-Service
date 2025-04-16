package com.tdit.user.UserService.services.impl;

import com.tdit.user.UserService.entities.Hotel;
import com.tdit.user.UserService.entities.Rating;
import com.tdit.user.UserService.entities.User;
import com.tdit.user.UserService.exceptions.ResourceNotFoundException;
import com.tdit.user.UserService.external.services.HotelService;
import com.tdit.user.UserService.external.services.RatingService;
import com.tdit.user.UserService.repositories.UserRepository;
import com.tdit.user.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

  /*  @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());


        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {

        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user is not available with given id:"+id));
        logger.info("{}",user);

        //THIS IS USING REST-TEMPLATE:-

       // Rating[] ratingArray=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        //List<Rating> ratingList= Arrays.stream(ratingArray).toList();

        ResponseEntity<List<Rating>> ratingListEntity=ratingService.getRatingsByUserId(user.getUserId());

        List<Rating> ratingList=ratingListEntity.getBody();

        List<Rating>returnedRatingList=ratingList.stream().map(rating->{
            //ResponseEntity<Hotel> hotelEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            //Hotel hotel=hotelEntity.getBody();
            //logger.info("{}",hotelEntity.getStatusCode());
            //logger.info("{}",hotel);
            ResponseEntity<Hotel> responseEntity=hotelService.getHotelById(rating.getHotelId());
            Hotel hotel=responseEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(returnedRatingList);
        logger.info("{}",returnedRatingList);

        return user;
    }

    @Override
    public String updateUser(User user, String id) {
        User user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user is not available wirh id:"+id));
        user1.setUserName(user.getUserName());
        user1.setUserEmail(user.getUserEmail());
        user1.setAbout(user.getAbout());

        userRepository.save(user1);
        return "User updated successfully";
    }

    @Override
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}

package com.tdit.user.UserService.services.impl;

import com.tdit.user.UserService.entities.User;
import com.tdit.user.UserService.exceptions.ResourceNotFoundException;
import com.tdit.user.UserService.repositories.UserRepository;
import com.tdit.user.UserService.services.UserService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

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
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user is not available with given id:"+id));
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

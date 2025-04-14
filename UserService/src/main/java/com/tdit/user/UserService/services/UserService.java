package com.tdit.user.UserService.services;

import com.tdit.user.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

     User createUser(User user);
     List<User> getAllUsers();
     User findUserById(String id);
     String updateUser(User user,String id);
     String deleteUser(String id);

}

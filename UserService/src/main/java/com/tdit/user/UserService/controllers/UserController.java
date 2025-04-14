package com.tdit.user.UserService.controllers;

import com.tdit.user.UserService.entities.User;
import com.tdit.user.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser=userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user=userService.findUserById(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable String userId){
        String message=userService.updateUser(user,userId);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        String message=userService.deleteUser(userId);
        return ResponseEntity.ok(message);
    }
}

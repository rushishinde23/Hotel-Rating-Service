package com.tdit.user.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

public ResourceNotFoundException(){
    super("resource on found !!!");
}

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

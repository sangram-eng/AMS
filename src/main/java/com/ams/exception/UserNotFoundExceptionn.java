package com.ams.exception;

public class UserNotFoundExceptionn extends RuntimeException{
    public UserNotFoundExceptionn(Long id){
        super("Could not found the user with id "+ id);
    }
}
    


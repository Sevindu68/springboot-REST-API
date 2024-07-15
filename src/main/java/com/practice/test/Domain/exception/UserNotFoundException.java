package com.practice.test.Domain.exception;

public class UserNotFoundException extends RuntimeException{

   public UserNotFoundException(String message){

       super(message);
    }
}

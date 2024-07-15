package com.practice.test.Domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException userNotFoundException) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<String> handleUserExistException(UserExistException userExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(userExistException.getMessage());
    }
}

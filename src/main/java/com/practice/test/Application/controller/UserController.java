package com.practice.test.Application.controller;

import com.practice.test.Application.dto.CreateUserDTO;
import com.practice.test.Application.dto.UpdateUserDTO;
import com.practice.test.Application.dto.UserDTO;
import com.practice.test.Domain.Entity.UserEntity;
import com.practice.test.Domain.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<UserDTO> showName(@RequestParam String name){
        return userService.getUser(name);
    }

    @GetMapping("/get2")
    public ResponseEntity<UserDTO> getUser(@RequestParam int age){
        return userService.getUserByAge(age);
    }

    @GetMapping("/get3/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable int id){
        return userService.getUserByID(id);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody CreateUserDTO user){
       return userService.addUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UpdateUserDTO userDTO){
        userService.updateUser(userDTO);
    }


}

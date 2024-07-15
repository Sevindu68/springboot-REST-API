package com.practice.test.Domain.service;

import com.practice.test.Application.dto.CreateUserDTO;
import com.practice.test.Application.dto.UpdateUserDTO;
import com.practice.test.Application.dto.UserDTO;
import com.practice.test.Domain.Entity.UserEntity;
import com.practice.test.Domain.exception.UserExistException;
import com.practice.test.Domain.exception.UserNotFoundException;
import com.practice.test.External.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<UserDTO> getUser(String name) {


        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> optionalUser = userRepository.findByName(name);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setAge(user.getAge());
            return ResponseEntity.ok().body(userDTO);
        } else {
            throw new UserNotFoundException("User Not Found");
        }

    }

    public ResponseEntity<UserDTO> getUserByAge(int age) {


        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> optionalUser = userRepository.findAge(age);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setAge(user.getAge());
            return ResponseEntity.ok().body(userDTO);
        } else {
            throw new UserNotFoundException("User Not Found");
        }

    }


    public ResponseEntity<UserEntity> addUser(CreateUserDTO user) {

        Optional<UserEntity> optionalUser = userRepository.findByName(user.getName());

        if (optionalUser.isPresent()) {
            throw new UserExistException("User Already Exist");

        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setAge(user.getAge());
        userEntity.setName(user.getName());
        userEntity.setJobRole(user.getJobRole());
        userEntity.setPassword(user.getPassword());
        System.out.println(user.getJobRole());
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    public ResponseEntity<UserEntity> updateUser(UpdateUserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setAge(userDTO.getAge());
        userEntity.setName(userDTO.getName());
        userEntity.setJobRole(userDTO.getJobRole());
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);

    }


    public ResponseEntity<UserDTO> getUserByID(int id) {

        UserDTO userDTO = new UserDTO();
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setAge(user.getAge());
            return ResponseEntity.ok().body(userDTO);
        }
        throw new UserNotFoundException("User Not Found");
    }
}

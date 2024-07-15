package com.practice.test.Application.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private int id;
    private String name;
    private  int age;
    private String jobRole;
    private String password;

}

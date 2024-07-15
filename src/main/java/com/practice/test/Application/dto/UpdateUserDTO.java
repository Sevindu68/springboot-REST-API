package com.practice.test.Application.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private int  id;
    private String name;
    private  int age;
    private String jobRole;
}

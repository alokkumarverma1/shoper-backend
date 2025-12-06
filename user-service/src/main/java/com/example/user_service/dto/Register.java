package com.example.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Register {
    private String name;
    private int number;
    private String email;
    private String password;
    private int age;
}

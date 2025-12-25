package com.example.shop_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private Long number;
    private String email;
    private String password;
    private int age;
}

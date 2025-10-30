package com.example.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registerdto {
    private String  name;
    private String email;
    private Long number;
    private String city;
    private String password;

}

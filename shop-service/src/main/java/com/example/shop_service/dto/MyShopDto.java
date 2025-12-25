package com.example.shop_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyShopDto {
    private String shopName;
    private String email;
    private Long number;
    private double latitude;
    private double longitude;
    private String city;
    private String state;

}

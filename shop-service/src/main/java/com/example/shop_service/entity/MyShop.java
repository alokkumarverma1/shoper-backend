package com.example.shop_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "myshop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;
    private String email;
    private Long number;
    private double latitude;
    private double longitude;
    private String city;
    private String state;
    private Long userId;

}

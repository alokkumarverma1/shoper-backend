package com.example.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userDetails")
public class UserDetails {
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int number;
    private String email;
    private String password;
    private int age;

}

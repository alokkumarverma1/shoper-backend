package com.example.user_service.repo;

import com.example.user_service.entity.UserDetails;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailrepo extends JpaRepository<UserDetails , Long> {
    String findByNumber(int number);

    UserDetails findByEmail(String email);
}

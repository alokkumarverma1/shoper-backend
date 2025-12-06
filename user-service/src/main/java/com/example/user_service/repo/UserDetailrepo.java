package com.example.user_service.repo;

import com.example.user_service.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailrepo extends JpaRepository<UserDetails , Long> {
}

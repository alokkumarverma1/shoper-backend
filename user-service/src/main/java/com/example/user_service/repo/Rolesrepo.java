package com.example.user_service.repo;

import com.example.user_service.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rolesrepo extends JpaRepository<Roles , Long> {
    Roles findByRolename(String user);
}

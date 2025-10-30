package com.example.user_service.repo;

import com.example.user_service.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Registerrepo extends JpaRepository<Register, Long> {
    Register findByNumber(Long number);
}

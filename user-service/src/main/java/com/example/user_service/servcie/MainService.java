package com.example.user_service.servcie;

import com.example.user_service.dto.Register;
import com.example.user_service.entity.UserDetails;
import com.example.user_service.repo.UserDetailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;

@Service
public class MainService {
    @Autowired
    private UserDetailrepo userDetailrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> register(Register register){
        System.out.println(register.getNumber() +""+register.getName());
        UserDetails userDetails = new UserDetails();
        userDetails.setName(register.getName());
        userDetails.setAge(register.getAge());
        userDetails.setNumber(userDetails.getNumber());
        userDetails.setEmail(register.getEmail());
        userDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        userDetailrepo.save(userDetails);
        return ResponseEntity.ok("register sucess");
    }
}

package com.example.user_service.controller;

import com.example.user_service.dto.RegisterDto;
import com.example.user_service.entity.Register;
import com.example.user_service.repo.Registerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class FeignClientController {

    @Autowired
    private Registerrepo registerrepo;

    @GetMapping("/userDetailsShop")
    public RegisterDto registerDto(@RequestHeader("X-MOBILE-NUMBER") Long number){
        Register register = registerrepo.findByNumber(number);
        if(register == null){
            throw new UsernameNotFoundException("user not found");
        }
        RegisterDto registerDto1 = new RegisterDto();
            registerDto1.setNumber(register.getNumber());
            registerDto1.setEmail(register.getEmail());
            registerDto1.setUserId(register.getId());
        return registerDto1;
    }
}

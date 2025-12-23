package com.example.user_service.security;

import com.example.user_service.entity.Register;
import com.example.user_service.repo.Registerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
public class UserDetailsServices implements UserDetailsService {

     @Autowired
     private Registerrepo registerrepo;
     @Autowired
     private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String number){

        Long num = Long.parseLong(number);
        Register register = registerrepo.findByNumber(num);
        if(register == null){
            throw new UsernameNotFoundException("user not found exception");
        }

        return new UserPrinciple(register);
    };


}

package com.example.user_service.servcie;

import com.example.user_service.dto.LoginDto;
import com.example.user_service.dto.Register;
import com.example.user_service.dto.Rolesdto;
import com.example.user_service.entity.Roles;
import com.example.user_service.entity.UserDetails;
import com.example.user_service.repo.Rolesrepo;
import com.example.user_service.repo.UserDetailrepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainService {
    @Autowired
    private UserDetailrepo userDetailrepo;
    @Autowired
    private Rolesrepo rolesrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> register(Register register){
         UserDetails email = userDetailrepo.findByEmail(register.getEmail());
        if(email != null){
            return ResponseEntity.ok("user already register");
        }
       else {
            UserDetails userDetails = new UserDetails();
            userDetails.setName(register.getName());
            userDetails.setAge(register.getAge());
            userDetails.setNumber(register.getNumber());
            userDetails.setEmail(register.getEmail());
            Roles roles = rolesrepo.findByRolename("user");
            if(roles == null){
                roles = new Roles();
                roles.setRolename("user");
                rolesrepo.save(roles);
            }
            Set<Roles> role = new HashSet<>();
            role.add(roles);
            userDetails.setRoles(role);
            userDetails.setPassword(passwordEncoder.encode(register.getPassword()));
            userDetailrepo.save(userDetails);
            return ResponseEntity.ok("register sucess");
        }
    }


//     this is login method

    public ResponseEntity<?> login(LoginDto loginDto){
       UserDetails userDetails1 = userDetailrepo.findByEmail(loginDto.getEmail());
       if(userDetails1 == null){
           return ResponseEntity.status(404).body("user not found");
       }
      if(passwordEncoder.matches(userDetails1.getPassword(),loginDto.getPassword())){
          return ResponseEntity.status(401).body("password not match");
      }
       List<String> roles = userDetails1.getRoles().stream().map(role -> role.getRolename()).collect(Collectors.toList());
       Map<String,Object> userdata = new HashMap<>();
       userdata.put("name",userDetails1.getName());
       userdata.put("email",userDetails1.getEmail());
       userdata.put("roles",roles);
        return ResponseEntity.ok().body(userdata);
    }



}

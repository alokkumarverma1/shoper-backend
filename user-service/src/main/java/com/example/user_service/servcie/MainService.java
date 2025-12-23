package com.example.user_service.servcie;

import com.example.user_service.dto.LoginDto;
import com.example.user_service.dto.RegisterDto;
import com.example.user_service.entity.Roles;
import com.example.user_service.entity.Register;
import com.example.user_service.repo.Rolesrepo;
import com.example.user_service.repo.Registerrepo;
import com.example.user_service.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService {
    @Autowired
    private Registerrepo registerrepo;
    @Autowired
    private Rolesrepo rolesrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterDto register){
         Register register1 = registerrepo.findByNumber(register.getNumber());
        if(register1 != null){
            return ResponseEntity.ok("user already register");
        }
       else {
            Register userDetails = new Register();
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
            registerrepo.save(userDetails);
            return ResponseEntity.ok("register sucess");
        }
    }


//     this is login method

    public ResponseEntity<?> login(LoginDto loginDto){
        System.out.println("this is number of login "+loginDto.getNumber());
       Register register = registerrepo.findByNumber(loginDto.getNumber());
             if(register == null){
                 return ResponseEntity.badRequest().body("user not found in login");
             }

       if(!passwordEncoder.matches(loginDto.getPassword(),register.getPassword())){
           return ResponseEntity.badRequest().body("password not match");
       }
        Map<String, Object> response = new HashMap<>();
     try{
         Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         loginDto.getNumber(),loginDto.getPassword()
                 )
         );
         String token = jwtService.generateToken(register);
         response.put("token", token);
         response.put("expiresIn", "1 hour");

     } catch (RuntimeException e) {
         throw new UsernameNotFoundException("user not found");
     }
        return ResponseEntity.ok().body(response);
    }



}

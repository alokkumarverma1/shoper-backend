package com.example.user_service.service;

import com.example.user_service.dto.Registerdto;
import com.example.user_service.entity.Register;
import com.example.user_service.entity.Roles;
import com.example.user_service.repo.Registerrepo;
import com.example.user_service.repo.Rolesrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Registerrepo registerrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Rolesrepo rolesrepo;


    // register acount
    public ResponseEntity<?> regsiter(Registerdto registerdto){
        Register register = new Register();
        register.setName(registerdto.getName());
        register.setCity(registerdto.getCity());
        register.setEmail(registerdto.getEmail());
        register.setNumber(register.getNumber());
        register.setPassword(passwordEncoder.encode(registerdto.getPassword()));
       if(registerdto.getNumber().equals("8172984928")){
           Roles roles = rolesrepo.findByRolename("admin");
           if(roles == null) {
               roles = new Roles();
               roles.setRolename("admin");
               register.setRoles(roles);
               rolesrepo.save(roles);
           }
       }else {
           Roles roles = rolesrepo.findByRolename("user");
           if(roles == null) {
               roles = new Roles();
               roles.setRolename("user");
               register.setRoles(roles);
               rolesrepo.save(roles);
           }
       }
        registerrepo.save(register);
        return ResponseEntity.ok("register sucess");
    }


    // login acount
    public ResponseEntity<?> login(Registerdto registerdto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerdto.getNumber(),registerdto.getPassword())
        );
        if(authentication.isAuthenticated()){
            return ResponseEntity.ok("authentication sucess");
        } else {
           return ResponseEntity.badRequest().body("authentication denied");
        }

    }



}

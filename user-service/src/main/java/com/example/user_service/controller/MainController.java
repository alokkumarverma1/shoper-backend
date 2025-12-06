package com.example.user_service.controller;


import com.example.user_service.dto.Register;
import com.example.user_service.servcie.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    private MainService mainService;

@GetMapping("/test")
 public String chek(){
    return "setup is sucess";
}

@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Register register){
    ResponseEntity data = mainService.register(register);
    return data;
}




}

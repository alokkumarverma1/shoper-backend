package com.example.user_service.controller;

import com.example.user_service.dto.Registerdto;
import com.example.user_service.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;



    @GetMapping("/test")
    public String test(){
        return "hwlloe spring boot";
    }

    @PostMapping("/register")
    public ResponseEntity<?> regsiter(@RequestBody Registerdto registerdto){
        ResponseEntity res = mainService.regsiter(registerdto);
        return res;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Registerdto registerdto){
        ResponseEntity res = mainService.regsiter(registerdto);
        return res;
    }


}

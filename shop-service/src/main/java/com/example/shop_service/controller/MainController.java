package com.example.shop_service.controller;

import com.example.shop_service.dto.MyShopDto;
import com.example.shop_service.entity.MyShop;
import com.example.shop_service.repo.MyShopRepo;
import com.example.shop_service.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class MainController {

    @Autowired
    private MyShopRepo myShopRepo;
    @Autowired
    private MainService mainService;

    @PostMapping("/create")
    public ResponseEntity<?> shopregister(@RequestBody MyShopDto myShopDto, Authentication authentication){

        if (authentication == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        Long usernum = Long.parseLong(authentication.getName());
        ResponseEntity res = mainService.createshop(usernum,myShopDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/myshop")
    public ResponseEntity<?> myshop(Authentication authentication){
        Long number = Long.parseLong(authentication.getName());
        ResponseEntity res =  mainService.myshop(number);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteshop(Authentication authentication){
        Long number = Long.parseLong(authentication.getName());
        ResponseEntity res = mainService.deleteAcount(number);
        return ResponseEntity.ok().body(res);
    };





}

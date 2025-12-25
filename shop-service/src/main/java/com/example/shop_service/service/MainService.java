package com.example.shop_service.service;

import com.example.shop_service.configration.UserServiceFeignConfigration;
import com.example.shop_service.dto.MyShopDto;
import com.example.shop_service.dto.UserDto;
import com.example.shop_service.entity.MyShop;
import com.example.shop_service.repo.MyShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class MainService {

    @Autowired
    private MyShopRepo myShopRepo;
    @Autowired
    private UserServiceFeignConfigration userServiceFeignConfigration;


// my shop
public ResponseEntity<?> myshop(Long number){
    MyShop myShop = myShopRepo.findByNumber(number);
    if(myShop == null){
        return ResponseEntity.ok().body("shop not found");
    }
    MyShopDto myShopDto = new MyShopDto();
    myShopDto.setShopName(myShop.getShopName());
    myShopDto.setCity(myShop.getCity());
    myShopDto.setNumber(myShop.getNumber());
    myShopDto.setEmail(myShop.getEmail());
    myShop.setState(myShop.getState());
    return ResponseEntity.ok().body(myShopDto);
}

// shop creating
    public ResponseEntity<?> createshop(Long usernum, MyShopDto myShopDto){
        MyShop myShop = myShopRepo.findByNumber(usernum);
        if(myShop == null){
            myShop = new MyShop();
            myShop.setShopName(myShopDto.getShopName());
            myShop.setLongitude(myShopDto.getLongitude());
            myShop.setLatitude(myShopDto.getLatitude());
            myShop.setState(myShopDto.getState());
            UserDto userDto;
            try {
                userDto = userServiceFeignConfigration.getUserDetails(usernum);
            } catch (Exception e) {
                return ResponseEntity
                        .status(500)
                        .body("User service unavailable");
            }
            myShop.setEmail(userDto.getEmail());
            myShop.setNumber(userDto.getNumber());
            myShop.setCity(myShopDto.getCity());
            myShop.setUserId(userDto.getUserId());
            myShopRepo.save(myShop);
        }else {
            return ResponseEntity.badRequest().body("this user alreay have a shop");
        }
        return ResponseEntity.ok("shop create sucess");
    }


    // delete acount
    public ResponseEntity<?> deleteAcount(Long number){
    MyShop myShop = myShopRepo.findByNumber(number);
    if(myShop == null){
        return ResponseEntity.badRequest().body("user not found");
    }
    myShopRepo.delete(myShop);
    return ResponseEntity.ok().body("acount delete sucess");
    }



}

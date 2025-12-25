package com.example.shop_service.configration;


import com.example.shop_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface UserServiceFeignConfigration {

    @GetMapping("/user/userDetailsShop")
    public UserDto getUserDetails(@RequestHeader("X-MOBILE-NUMBER") Long number);

}

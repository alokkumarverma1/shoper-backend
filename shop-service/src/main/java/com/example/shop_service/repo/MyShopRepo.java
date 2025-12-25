package com.example.shop_service.repo;

import com.example.shop_service.entity.MyShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyShopRepo extends JpaRepository<MyShop,Long> {
    MyShop findByNumber(Long number);
}

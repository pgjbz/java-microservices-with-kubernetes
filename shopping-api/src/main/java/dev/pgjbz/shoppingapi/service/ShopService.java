package dev.pgjbz.shoppingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import dev.pgjbz.shoppingapi.models.Shop;

public interface ShopService {
    
    List<Shop> findAll();
    List<Shop> findByUser(String userIdentifier);
    List<Shop> findByDate(LocalDateTime date);
    Shop findById(Long id);
    Shop save(Shop shop);
}

package dev.pgjbz.shoppingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import dev.pgjbz.shoppingapi.dto.report.ShopReportDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopFilterDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopReportFilterDTO;
import dev.pgjbz.shoppingapi.models.Shop;

public interface ShopService {
    
    List<Shop> findAll();
    List<Shop> findByUser(String userIdentifier);
    List<Shop> findByDate(LocalDateTime date);
    List<Shop> findByFilter(ShopFilterDTO filter);
    ShopReportDTO reportByFilter(ShopReportFilterDTO filter);
    Shop findById(Long id);
    Shop save(Shop shop);
}

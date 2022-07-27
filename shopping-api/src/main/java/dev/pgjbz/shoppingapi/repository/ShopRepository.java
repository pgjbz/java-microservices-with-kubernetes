package dev.pgjbz.shoppingapi.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pgjbz.shoppingapi.models.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserIdentifier(String userIdentifier);
    List<Shop> findAllByTotalGreaterThan(Double total);
    List<Shop> findAllByDateGreaterThanEqual(LocalDateTime date);
    List<Shop> findByUserIdentifier(String userIdentifier);
}

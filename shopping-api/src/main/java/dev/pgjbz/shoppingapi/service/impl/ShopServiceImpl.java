package dev.pgjbz.shoppingapi.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import dev.pgjbz.shoppingapi.models.Item;
import dev.pgjbz.shoppingapi.models.Shop;
import dev.pgjbz.shoppingapi.repository.ShopRepository;
import dev.pgjbz.shoppingapi.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Override
    public List<Shop> findAll() {
        log.info("fetch all shop");
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> findByUser(String userIdentifier) {
        log.info("perform fetch by user identifier {}", userIdentifier);
        return shopRepository.findByUserIdentifier(userIdentifier);
    }

    @Override
    public List<Shop> findByDate(LocalDateTime date) {
        log.info("perform fetch by date {}", date);
        return shopRepository.findAllByDateGreaterThanEqual(date);
    }

    @Override
    public Shop findById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("no shop founded by id %s", id)));
    }

    @Override
    public Shop save(Shop shop) {
        shop.setTotal(
                shop.getItems()
                        .stream()
                        .map(Item::getPrice)
                        .reduce(0D, Double::sum));
        shop.setDate(LocalDateTime.now());
        return shopRepository.save(shop);
    }

}

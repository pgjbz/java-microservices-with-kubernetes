package dev.pgjbz.shoppingapi.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import dev.pgjbz.core.dto.report.ShopReportDTO;
import dev.pgjbz.core.dto.request.ShopFilterDTO;
import dev.pgjbz.core.dto.request.ShopReportFilterDTO;
import dev.pgjbz.core.dto.response.ProductResponseDTO;
import dev.pgjbz.shoppingapi.models.Item;
import dev.pgjbz.shoppingapi.models.Shop;
import dev.pgjbz.shoppingapi.repository.ShopReportRepository;
import dev.pgjbz.shoppingapi.repository.ShopRepository;
import dev.pgjbz.shoppingapi.service.ProductService;
import dev.pgjbz.shoppingapi.service.ShopService;
import dev.pgjbz.shoppingapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopReportRepository shopReportRepository;
    private final ProductService productService;
    private final UserService userService;

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
    public Shop save(Shop shop, String key) {
        if (Objects.isNull(userService.findUserByDocumentAndKey(shop.getUserIdentifier(), key)))
            throw new NoResultException(
                    String.format("no user founded with document %s", shop.getUserIdentifier()));
        var items = shop.getItems();
        var products = items.stream()
                .map(item -> productService.findByIdentifier(item.getProductIdentifier()))
                .collect(Collectors.toSet());
        shop.setItems(products
                .stream()
                .map(p -> Item.builder()
                        .productIdentifier(p.productIdentifier())
                        .price(p.price())
                        .build())
                .collect(Collectors.toSet()));
        shop.setTotal(
                products
                        .stream()
                        .map(ProductResponseDTO::price)
                        .reduce(0D, Double::sum));
        shop.setDate(LocalDateTime.now());
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> findByFilter(ShopFilterDTO filter) {
        return shopReportRepository.findShopByFilter(filter);
    }

    @Override
    public ShopReportDTO reportByFilter(ShopReportFilterDTO filter) {
        return shopReportRepository.findReportByDate(filter);
    }

}

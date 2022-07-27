package dev.pgjbz.shoppingapi.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pgjbz.shoppingapi.dto.request.ShopRequestDTO;
import dev.pgjbz.shoppingapi.dto.response.ShopResponseDTO;
import dev.pgjbz.shoppingapi.models.Shop;
import dev.pgjbz.shoppingapi.service.ShopService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/shoppings")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<Stream<ShopResponseDTO>> findAll() {
        return ResponseEntity.ok(toShopResponse(shopService.findAll()));
    }

    @GetMapping(value = "/date/{date}")
    public ResponseEntity<Stream<ShopResponseDTO>> findByDate(
            @PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return ResponseEntity.ok(toShopResponse(shopService.findByDate(date)));
    }

    @GetMapping(value = "/user/{userIdentifier}")
    public ResponseEntity<Stream<ShopResponseDTO>> findByUserIdentifier(
            @PathVariable(value = "userIdentifier") String userIdentifier) {
        return ResponseEntity.ok(toShopResponse(shopService.findByUser(userIdentifier)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ShopResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ShopResponseDTO(shopService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ShopResponseDTO> save(@RequestBody ShopRequestDTO shopRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ShopResponseDTO(shopService.save(shopRequestDTO.toShopModel())));
    }

    private final Stream<ShopResponseDTO> toShopResponse(List<Shop> shops) {
        return shops.stream().map(ShopResponseDTO::new);
    }
}

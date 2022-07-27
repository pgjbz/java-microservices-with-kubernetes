package dev.pgjbz.shoppingapi.dto.response;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import dev.pgjbz.shoppingapi.models.Shop;

public record ShopResponseDTO(
        String userIdentifier,
        Double total,
        LocalDateTime date,
        Set<ItemResponseDTO> items) {

    public ShopResponseDTO(Shop shop) {
        this(shop.getUserIdentifier(), shop.getTotal(), shop.getDate(),
                Objects.nonNull(shop.getItems()) ? shop.getItems()
                        .stream()
                        .map(ItemResponseDTO::new)
                        .collect(Collectors.toSet()) : Collections.emptySet());
    }

}

package dev.pgjbz.shoppingapi.dto.request;

import java.util.Set;
import java.util.stream.Collectors;

import dev.pgjbz.shoppingapi.models.Shop;

public record ShopRequestDTO(
        String userIdentifier,
        Set<ItemRequestDTO> items) {
    public Shop toShopModel() {
        return Shop.builder()
                .userIdentifier(userIdentifier)
                .items(items.stream()
                        .map(ItemRequestDTO::toItemModel)
                        .collect(Collectors.toSet()))
                .build();
    }
}

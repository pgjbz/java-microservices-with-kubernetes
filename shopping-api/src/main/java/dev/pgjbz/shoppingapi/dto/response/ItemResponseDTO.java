package dev.pgjbz.shoppingapi.dto.response;

import dev.pgjbz.shoppingapi.models.Item;

public record ItemResponseDTO(
    String productIdentifier,
    Double price
) {
    public ItemResponseDTO(Item item) {
        this(item.getProductIdentifier(), item.getPrice());
    }
}

package dev.pgjbz.shoppingapi.dto.request;

import dev.pgjbz.shoppingapi.models.Item;

public record ItemRequestDTO(
        String productIdentifier,
        Double price
/*
 * for now use this, but in future we
 * call the product-api to get price of a product
 */
) {
    public Item toItemModel() {
        return Item.builder()
                .productIdentifier(productIdentifier)
                .price(price)
                .build();
    }
}

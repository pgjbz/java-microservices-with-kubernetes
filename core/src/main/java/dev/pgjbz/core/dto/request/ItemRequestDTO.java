package dev.pgjbz.core.dto.request;


public record ItemRequestDTO(
        String productIdentifier,
        Double price
/*
 * for now use this, but in future we
 * call the product-api to get price of a product
 */
) {

}

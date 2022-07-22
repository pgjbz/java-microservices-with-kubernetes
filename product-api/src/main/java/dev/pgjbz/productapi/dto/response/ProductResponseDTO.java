package dev.pgjbz.productapi.dto.response;

import static java.util.Optional.ofNullable;

import dev.pgjbz.productapi.models.Product;

public record ProductResponseDTO(
        String name,
        Double price,
        String description,
        String productIdentifier,
        CategoryResponseDTO category) {

    public ProductResponseDTO(Product product) {
        this(product.getName(), product.getPrice(), product.getDescription(), product.getProductIdentifier(),
                ofNullable(product.getCategory())
                        .map(CategoryResponseDTO::new).orElse(null));
    }
}

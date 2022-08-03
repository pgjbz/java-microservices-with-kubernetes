package dev.pgjbz.core.dto.response;

public record ProductResponseDTO(
        String name,
        Double price,
        String description,
        String productIdentifier,
        CategoryResponseDTO category) {

}

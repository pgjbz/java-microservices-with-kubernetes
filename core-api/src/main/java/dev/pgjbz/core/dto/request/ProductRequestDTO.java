package dev.pgjbz.core.dto.request;

public record ProductRequestDTO(
                String name,
                Double price,
                String description,
                String productIdentifier,
                Long categoryId) {

}

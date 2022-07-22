package dev.pgjbz.productapi.dto.response;

import dev.pgjbz.productapi.models.Category;

public record CategoryResponseDTO(
        Long id,
        String name) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName());
    }
}

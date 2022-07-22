package dev.pgjbz.productapi.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import dev.pgjbz.productapi.models.Category;
import dev.pgjbz.productapi.models.Product;
import dev.pgjbz.productapi.services.validators.CreateUnique;

@CreateUnique
public record ProductRequestDTO(
                @NotBlank String name,
                @NotNull @PositiveOrZero Double price,
                @NotBlank String description,
                @NotBlank String productIdentifier,
                @NotNull Long categoryId) {

        public Product toProductModel() {
                return Product.builder()
                                .name(name)
                                .price(price)
                                .description(description)
                                .productIdentifier(productIdentifier)
                                .category(
                                                Category.builder()
                                                                .id(categoryId)
                                                                .build())
                                .build();
        }

}

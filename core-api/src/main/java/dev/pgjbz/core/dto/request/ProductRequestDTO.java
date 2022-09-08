package dev.pgjbz.core.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public record ProductRequestDTO(
                @NotBlank(message = "name is mandatory")
                String name,
                @NotNull(message = "price is mandatory")
                @PositiveOrZero(message ="price cannot be negative")
                Double price,
                @NotBlank(message = "description is mandatory")
                String description,
                @NotBlank(message = "identifier is mandatory")
                String productIdentifier,
                @NotNull(message = "category id is mandatory")
                Long categoryId) {

}

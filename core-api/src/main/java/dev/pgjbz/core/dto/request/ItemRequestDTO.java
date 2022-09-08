package dev.pgjbz.core.dto.request;

import javax.validation.constraints.NotBlank;

public record ItemRequestDTO(
        @NotBlank(message = "product identifer is mandatory")
        String productIdentifier,
        Double price
/*
 * for now use this, but in future we
 * call the product-api to get price of a product
 */
) {

}

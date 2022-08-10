package dev.pgjbz.shoppingapi.service;

import dev.pgjbz.core.dto.response.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO findByIdentifier(String productIdentifier);
}

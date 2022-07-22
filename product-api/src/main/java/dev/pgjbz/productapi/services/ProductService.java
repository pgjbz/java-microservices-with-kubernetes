package dev.pgjbz.productapi.services;

import java.util.List;

import dev.pgjbz.productapi.models.Product;

public interface ProductService {
    List<Product> findAll();
    List<Product> findByCategory(Long categoryId);
    Product findByIdentifier(String identifier);
    void deleteById(Long productId);
    Product createProduct(Product product);

}

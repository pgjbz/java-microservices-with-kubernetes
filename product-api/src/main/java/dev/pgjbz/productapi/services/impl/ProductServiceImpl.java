package dev.pgjbz.productapi.services.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import dev.pgjbz.productapi.models.Product;
import dev.pgjbz.productapi.repository.CategoryRepository;
import dev.pgjbz.productapi.repository.ProductRepository;
import dev.pgjbz.productapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> findAll() {
        log.info("fetching all products");
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        log.info("find products by category {}", categoryId);
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, () -> {
                    throw new NoResultException(
                            String.format("product with id %s not found", productId));
                });

    }

    @Override
    public Product findByIdentifier(String productIdentifier) {
        return productRepository.findByProductIdentifier(productIdentifier).orElseThrow(
                () -> new NoResultException(String.format("product with identifier %s not found", productIdentifier)));
    }

    @Override
    public Product createProduct(Product product) {
        final var categoryId = product.getCategory().getId();
        if(!categoryRepository.existsById(categoryId)) {
            throw new NoResultException(String.format("categiory with identifier %s not found", categoryId));
        }
        return productRepository.save(product);
    }

}

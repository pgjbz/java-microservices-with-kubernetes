package dev.pgjbz.productapi.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pgjbz.productapi.dto.request.ProductRequestDTO;
import dev.pgjbz.productapi.dto.response.ProductResponseDTO;
import dev.pgjbz.productapi.models.Product;
import dev.pgjbz.productapi.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<Stream<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(mapToResponseDTO(productService.findAll()));
    }

    @GetMapping(value = "/category/{categoryId}")
    public ResponseEntity<Stream<ProductResponseDTO>> findByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(mapToResponseDTO(productService.findByCategory(categoryId)));
    }

    @GetMapping(value = "/{productIdentifier}")
    public ResponseEntity<ProductResponseDTO> findByIdentifier(
            @PathVariable(value = "productIdentifier") String productIdentifier) {
        return ResponseEntity.ok(new ProductResponseDTO(productService.findByIdentifier(productIdentifier)));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductResponseDTO(productService.createProduct(productRequestDTO.toProductModel())));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private final Stream<ProductResponseDTO> mapToResponseDTO(List<Product> products) {
        return products.stream().map(ProductResponseDTO::new);
    }

}

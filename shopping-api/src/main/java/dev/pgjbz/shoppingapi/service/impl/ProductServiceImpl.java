package dev.pgjbz.shoppingapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.pgjbz.core.dto.response.ProductResponseDTO;
import dev.pgjbz.shoppingapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


    private static final String BASE_URL = "http://localhost:8081/products/{productIdentifier}";

    @Override
    public ProductResponseDTO findByIdentifier(String productIdentifier) {
        log.info("search product by identifier {}", productIdentifier);
        final var restTemplate = new RestTemplate();    
        ResponseEntity<ProductResponseDTO> response = restTemplate.getForEntity(BASE_URL, ProductResponseDTO.class, productIdentifier);    
        return response.getBody();
    }

}
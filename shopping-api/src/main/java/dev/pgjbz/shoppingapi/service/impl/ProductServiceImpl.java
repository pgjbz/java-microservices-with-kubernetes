package dev.pgjbz.shoppingapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.pgjbz.core.dto.response.ProductResponseDTO;
import dev.pgjbz.shoppingapi.config.UrlsConfig;
import dev.pgjbz.shoppingapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final UrlsConfig urlsConfig;

    @Override
    public ProductResponseDTO findByIdentifier(String productIdentifier) {
        log.info("search product by identifier {}", productIdentifier);
        final var restTemplate = new RestTemplate();
        ResponseEntity<ProductResponseDTO> response = restTemplate.getForEntity(
                urlsConfig.productApi() + "{productIdentifier}", ProductResponseDTO.class, productIdentifier);
        return response.getBody();
    }

}
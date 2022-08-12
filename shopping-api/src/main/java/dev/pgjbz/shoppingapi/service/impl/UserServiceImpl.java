package dev.pgjbz.shoppingapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.shoppingapi.config.UrlsConfig;
import dev.pgjbz.shoppingapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UrlsConfig urlsConfig;

    @Override
    public UserResponseDTO findUserByDocumentAndKey(String document, String key) {
        log.info("perform search by document {}", document);
        final var restTemplate = new RestTemplate();
        var builder = UriComponentsBuilder.fromHttpUrl(urlsConfig.userApi() + document);
        builder.queryParam("key", key);
        ResponseEntity<UserResponseDTO> response = restTemplate.getForEntity(builder.toUriString(), UserResponseDTO.class);
        return response.getBody();
    }
    
}

package dev.pgjbz.shoppingapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.shoppingapi.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    
    private static final String BASE_URL = "http://localhost:8080/users/";


    @Override
    public UserResponseDTO findUserByDocumentAndKey(String document, String key) {
        log.info("perform search by document {}", document);
        final var restTemplate = new RestTemplate();
        var builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + document);
        builder.queryParam("key", key);
        ResponseEntity<UserResponseDTO> response = restTemplate.getForEntity(builder.toUriString(), UserResponseDTO.class);
        return response.getBody();
    }
    
}

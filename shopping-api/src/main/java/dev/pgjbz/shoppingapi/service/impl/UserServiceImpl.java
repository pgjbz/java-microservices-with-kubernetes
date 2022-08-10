package dev.pgjbz.shoppingapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.shoppingapi.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    
    private static final String BASE_URL = "http://localhost:8080/users/{document}";


    @Override
    public UserResponseDTO findUserByDocument(String document) {
        log.info("perform search by document {}", document);
        final var restTemplate = new RestTemplate();
        ResponseEntity<UserResponseDTO> response = restTemplate.getForEntity(BASE_URL, UserResponseDTO.class, document);
        return response.getBody();
    }
    
}

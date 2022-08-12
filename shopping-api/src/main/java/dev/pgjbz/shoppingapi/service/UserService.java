package dev.pgjbz.shoppingapi.service;

import dev.pgjbz.core.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO findUserByDocumentAndKey(String document, String key);
}

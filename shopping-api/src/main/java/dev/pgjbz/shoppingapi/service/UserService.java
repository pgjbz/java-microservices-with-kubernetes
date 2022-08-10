package dev.pgjbz.shoppingapi.service;

import dev.pgjbz.core.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO findUserByDocument(String document);
}

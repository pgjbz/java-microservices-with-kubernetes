package dev.pgjbz.userapi.infra.dto.response;

import java.time.LocalDateTime;

import dev.pgjbz.userapi.domain.models.User;

public record UserResponseDTO(
        Long id,
        String name,
        String document,
        String address,
        String email,
        String phone,
        LocalDateTime registerDate) {

    public UserResponseDTO(User user) {
        this(user.id(), user.name(), user.document(), user.address(), user.email(), user.phone(), user.registerDate());
    }

}

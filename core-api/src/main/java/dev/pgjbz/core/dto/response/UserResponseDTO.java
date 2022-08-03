package dev.pgjbz.core.dto.response;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String document,
        String address,
        String email,
        String phone,
        LocalDateTime registerDate) {

}

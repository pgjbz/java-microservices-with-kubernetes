package dev.pgjbz.core.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        Long id,
        String name,
        String document,
        String address,
        String email,
        String phone,
        UUID key,
        LocalDateTime registerDate) {

}

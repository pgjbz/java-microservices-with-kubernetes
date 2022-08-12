package dev.pgjbz.userapi.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record User(
    Long id,
    String name,
    String document,
    String address,
    String email,
    String phone,
    UUID key,
    LocalDateTime registerDate
) {
    
}

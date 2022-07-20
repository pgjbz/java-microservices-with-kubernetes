package dev.pgjbz.userapi.domain.models;

import java.time.LocalDateTime;

public record User(
    Long id,
    String name,
    String document,
    String address,
    String email,
    String phone,
    LocalDateTime registerDate
) {
    
}

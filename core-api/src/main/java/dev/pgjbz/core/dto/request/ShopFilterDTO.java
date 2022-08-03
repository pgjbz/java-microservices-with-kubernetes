package dev.pgjbz.core.dto.request;

import java.time.LocalDateTime;
import java.util.Optional;


public record ShopFilterDTO(
    LocalDateTime startDate,
    Optional<LocalDateTime> endDate,
    Optional<Double> minValue
) {
    
}

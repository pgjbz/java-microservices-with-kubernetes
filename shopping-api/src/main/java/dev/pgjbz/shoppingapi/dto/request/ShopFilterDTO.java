package dev.pgjbz.shoppingapi.dto.request;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public record ShopFilterDTO(
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime startDate,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Optional<LocalDateTime> endDate,
    Optional<Double> minValue
) {
    
}

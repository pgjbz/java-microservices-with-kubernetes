package dev.pgjbz.shoppingapi.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public record ShopReportFilterDTO(
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime startDate,
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime endDate
) {
    
}

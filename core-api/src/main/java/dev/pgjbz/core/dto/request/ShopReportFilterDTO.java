package dev.pgjbz.core.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


public record ShopReportFilterDTO(
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime startDate,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime endDate
) {
    
}

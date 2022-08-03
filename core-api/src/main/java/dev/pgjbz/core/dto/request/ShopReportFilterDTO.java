package dev.pgjbz.core.dto.request;

import java.time.LocalDateTime;


public record ShopReportFilterDTO(
    LocalDateTime startDate,
    LocalDateTime endDate
) {
    
}

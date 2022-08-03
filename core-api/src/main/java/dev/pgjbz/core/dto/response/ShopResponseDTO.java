package dev.pgjbz.core.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record ShopResponseDTO(
        String userIdentifier,
        Double total,
        LocalDateTime date,
        Set<ItemResponseDTO> items) {

}

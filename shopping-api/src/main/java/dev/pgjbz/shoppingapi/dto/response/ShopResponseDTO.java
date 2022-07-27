package dev.pgjbz.shoppingapi.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ShopResponseDTO(
    String userIdentifier,
    Double total,
    LocalDateTime date,
    List<ItemResponseDTO> items
) {
    
}

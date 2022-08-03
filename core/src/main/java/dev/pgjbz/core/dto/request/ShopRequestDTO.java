package dev.pgjbz.core.dto.request;

import java.util.Set;


public record ShopRequestDTO(
        String userIdentifier,
        Set<ItemRequestDTO> items) {

}

package dev.pgjbz.core.dto.request;

import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


public record ShopRequestDTO(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        String userIdentifier,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Set<String> items) {

}

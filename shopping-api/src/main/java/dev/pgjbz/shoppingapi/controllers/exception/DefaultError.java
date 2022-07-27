package dev.pgjbz.shoppingapi.controllers.exception;

import java.time.LocalDateTime;

public record DefaultError(
    LocalDateTime timestamp,
    int status,
    String error,
    String path
) {
    
}


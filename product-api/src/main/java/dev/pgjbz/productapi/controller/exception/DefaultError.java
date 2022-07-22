package dev.pgjbz.productapi.controller.exception;

import java.time.LocalDateTime;

public record DefaultError(
    LocalDateTime timestamp,
    int status,
    String error,
    String path
) {
    
}


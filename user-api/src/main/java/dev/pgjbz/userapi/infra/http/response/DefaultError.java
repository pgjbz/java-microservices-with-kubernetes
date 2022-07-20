package dev.pgjbz.userapi.infra.http.response;

import java.time.LocalDateTime;

public record DefaultError(
    LocalDateTime timestamp,
    int status,
    String error,
    String path
) {
    
}


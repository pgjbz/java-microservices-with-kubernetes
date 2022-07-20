package dev.pgjbz.userapi.infra.http.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.pgjbz.userapi.domain.exceptions.NotFoundException;
import dev.pgjbz.userapi.infra.http.response.DefaultError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultError> notFound(NotFoundException ex, HttpServletRequest servletRequest) {
        final var path = servletRequest.getRequestURI();
        final var status = HttpStatus.NOT_FOUND;
        final var defaultError = new DefaultError(LocalDateTime.now(), status.value(), ex.getMessage(), path);
        return ResponseEntity.status(status)
                .body(defaultError);

    }

}

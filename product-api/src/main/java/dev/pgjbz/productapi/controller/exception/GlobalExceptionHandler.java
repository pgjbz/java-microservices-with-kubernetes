package dev.pgjbz.productapi.controller.exception;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<DefaultError> notFound(NoResultException ex, HttpServletRequest servletRequest) {
        final var path = servletRequest.getRequestURI();
        final var status = HttpStatus.NOT_FOUND;
        final var defaultError = new DefaultError(LocalDateTime.now(), status.value(), ex.getMessage(), path);
        return ResponseEntity.status(status)
                .body(defaultError);

    }
}

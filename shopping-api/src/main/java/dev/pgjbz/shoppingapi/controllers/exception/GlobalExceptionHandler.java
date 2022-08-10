package dev.pgjbz.shoppingapi.controllers.exception;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ObjectMapper mapper;

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<DefaultError> notFound(NoResultException ex, HttpServletRequest servletRequest) {
        final var path = servletRequest.getRequestURI();
        final var status = HttpStatus.NOT_FOUND;
        final var defaultError = new DefaultError(LocalDateTime.now(), status.value(), ex.getMessage(), path);
        return ResponseEntity.status(status)
                .body(defaultError);
    }

    @SneakyThrows
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<DefaultError> notFound(HttpClientErrorException.NotFound ex,
            HttpServletRequest servletRequest) {
        final var path = servletRequest.getRequestURI();
        final var status = HttpStatus.NOT_FOUND;
        var message = mapper.readValue(ex.getResponseBodyAsString(), DefaultError.class).error();
        final var defaultError = new DefaultError(LocalDateTime.now(), status.value(), message, path);
        return ResponseEntity.status(status)
                .body(defaultError);
    }
}

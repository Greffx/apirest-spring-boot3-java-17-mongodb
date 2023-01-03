package com.eduardogreff.workshopmongo.controllers.exception;

import com.eduardogreff.workshopmongo.config.exception.ErrorConfig;
import com.eduardogreff.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorConfig> notFoundError(HttpServletRequest httpServletRequest, ObjectNotFoundException exception) {
        ErrorConfig errorConfig = new ErrorConfig(
                HttpStatus.NOT_FOUND.value(),
                "Field ID.",
                "Object doesn't exist.",
                httpServletRequest.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorConfig);
    }


}

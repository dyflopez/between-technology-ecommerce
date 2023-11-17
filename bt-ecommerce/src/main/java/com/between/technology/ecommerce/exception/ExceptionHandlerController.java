package com.between.technology.ecommerce.exception;

import com.between.technology.ecommerce.config.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerController {

    private final ExceptionConfigs exceptionConfigs;

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyHandleException(MyHandleException ex) {
        log.error("{} {}", ExceptionConfigs.BUSINESS, ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(exceptionConfigs.getExceptionMessage(ExceptionConfigs.BUSINESS) + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error("{} {}", exceptionConfigs.getExceptionMessage(ExceptionConfigs.SYSTEM), ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionConfigs.getExceptionMessage(ExceptionConfigs.SYSTEM) + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        log.error("{} error info:\n{}", exceptionConfigs.getExceptionMessage(ExceptionConfigs.SYSTEM), errors);
        return ResponseEntity.badRequest().body(errors);
    }
}


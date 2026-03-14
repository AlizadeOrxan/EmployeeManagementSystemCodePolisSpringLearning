package com.ltc.employeemanagementsystemcodepolisspringlearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

        // Validasiya xətalarını tutmaq üçün (məsələn: ad boşdursa)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();

            ex.getBindingResult().getFieldErrors().forEach(err ->
                    errors.put(err.getField(), err.getDefaultMessage())
            );

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }


        @ExceptionHandler(EmployeeNotFoundException.class)
        @ResponseStatus(HttpStatus.CONFLICT)
        public ErrorResponse handleEmployeeNotFound(EmployeeNotFoundException ex ) {
            return new  ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

//
//            ErrorResponse error = ErrorResponse.builder()
//                    .message(ex.getMessage())
//                    .statusCode(HttpStatus.NO_CONTENT.value())
//                    .timestamp(LocalDateTime.now())
//                    .build();
//
//            return error;

        }


        @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String>  handleUserNotFound(UserNotFoundException ex ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }



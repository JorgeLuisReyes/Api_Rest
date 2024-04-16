package com.sybven.jwt.token.controllers;

import com.sybven.jwt.token.dto.ErrorResponseDTO;
import com.sybven.jwt.token.dto.GenericDTO;
import com.sybven.jwt.token.exceptions.CustomApiUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
        List<GenericDTO> errors = ex.getBindingResult()
                .getAllErrors().stream()
                .map(objectError -> GenericDTO.builder()
                        .message(objectError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(ErrorResponseDTO.builder()
                .status("Solicitud incorrecta")
                .code((long) HttpStatus.BAD_REQUEST.value())
                .messages(errors)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiUnauthorizedException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomApiUnauthorizedException(CustomApiUnauthorizedException ex) {

            List<GenericDTO> errors = List.of(GenericDTO.builder()
                .message(ex.getMessage())
                .build());
        
                return new ResponseEntity<>(ErrorResponseDTO.builder()
                .status("Solicitud incorrecta")
                .code((long) HttpStatus.BAD_REQUEST.value())
                .messages(errors)
                .build(), HttpStatus.BAD_REQUEST);
    }
}

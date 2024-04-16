package com.sybven.jwt.token.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception {

    public ApiUnauthorized(String message) {
        super(message);
    }
 
}
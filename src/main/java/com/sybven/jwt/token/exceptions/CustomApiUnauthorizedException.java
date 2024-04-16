package com.sybven.jwt.token.exceptions;

public class CustomApiUnauthorizedException extends RuntimeException {
    private final String message;

    public CustomApiUnauthorizedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}


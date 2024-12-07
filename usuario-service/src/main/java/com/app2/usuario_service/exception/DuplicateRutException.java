package com.app2.usuario_service.exception;

public class DuplicateRutException extends RuntimeException {
    public DuplicateRutException(String message) {
        super(message);
    }
}

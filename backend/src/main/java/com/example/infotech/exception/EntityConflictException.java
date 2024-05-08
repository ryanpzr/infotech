package com.example.infotech.exception;

public class EntityConflictException extends Throwable {

    public EntityConflictException() {
    }

    public EntityConflictException(String message) {
        super(message);
    }

    public EntityConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityConflictException(Throwable cause) {
        super(cause);
    }
}

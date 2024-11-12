package com.wora.wrm.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message, Object id) {
        super("Entity " + message + "Id " + id);
    }
}

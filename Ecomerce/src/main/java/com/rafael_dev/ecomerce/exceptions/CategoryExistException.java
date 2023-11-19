package com.rafael_dev.ecomerce.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryExistException extends RuntimeException{

    private final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public CategoryExistException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}

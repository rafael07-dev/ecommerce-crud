package com.rafael_dev.ecomerce.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundCategory extends RuntimeException{

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundCategory(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}

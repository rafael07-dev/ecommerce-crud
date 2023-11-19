package com.rafael_dev.ecomerce.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundProduct extends RuntimeException {

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundProduct(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}

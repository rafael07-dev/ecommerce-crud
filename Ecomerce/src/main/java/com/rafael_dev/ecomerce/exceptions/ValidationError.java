package com.rafael_dev.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import java.util.List;

public class ValidationError {

    private List<String> errors;
    private HttpStatus status;

    public ValidationError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

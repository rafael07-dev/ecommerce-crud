package com.rafael_dev.ecomerce.utils;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponse {

    private boolean success;
    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp = getTime();

    private LocalDateTime getTime(){
        return LocalDateTime.now();
    }

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, HttpStatus status, LocalDateTime timeStamp) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}

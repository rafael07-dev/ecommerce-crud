package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.exceptions.CategoryExistException;
import com.rafael_dev.ecomerce.exceptions.NotFoundCategory;
import com.rafael_dev.ecomerce.exceptions.NotFoundProduct;
import com.rafael_dev.ecomerce.exceptions.ValidationError;
import com.rafael_dev.ecomerce.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundProduct.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerException(NotFoundProduct ex){
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        response.setStatus(ex.getStatus());
        response.setTimeStamp(response.getTimeStamp());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundCategory.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerException(NotFoundCategory ex) {
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        response.setStatus(ex.getStatus());
        response.setTimeStamp(response.getTimeStamp());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<ValidationError> validationExeption(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ValidationError(errors));
    }

    @ExceptionHandler(value = {CategoryExistException.class})
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerExistException(CategoryExistException ex) {
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        response.setStatus(ex.getStatus());
        response.setTimeStamp(response.getTimeStamp());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

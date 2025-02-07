package com.cinema.videotecha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cinema.videotecha.dto.ErrorResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString(), exception.getMessage());

    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.toString(), exception.getMessage());

    }

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusinessLogicException(BusinessLogicException exception) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.toString(), exception.getMessage());

    }

    @ExceptionHandler
    public String handleMethodValidationFailure(final MethodArgumentNotValidException ex) {
        StringBuilder b = new StringBuilder();
        BindingResult results = ex.getBindingResult();
        for (FieldError e : results.getFieldErrors()) {
            b.append(e.getDefaultMessage()).append(" -> ").append(e.getField());
        }
        return b.toString();
    }


}

package com.booking.tickets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionsController {
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse notFound(NoSuchElementException exception) {
        return ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Error: " + exception.getMessage());
    }
}

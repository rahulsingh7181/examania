package com.examania.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllException(Exception exception, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "SERVER ERROR", details);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "RECORD NOT FOUND", details);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

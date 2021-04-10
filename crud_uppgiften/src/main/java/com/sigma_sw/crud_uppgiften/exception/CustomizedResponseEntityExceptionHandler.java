package com.sigma_sw.crud_uppgiften.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.validation.Validator;
import java.util.Date;


@RestController
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex
            , HttpHeaders headers
            , HttpStatus status
            , WebRequest request) {


        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date()
                , exception.getMessage()
                , webRequest.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> handleProductNotFoundExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date()
                , exception.getMessage()
                , webRequest.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}

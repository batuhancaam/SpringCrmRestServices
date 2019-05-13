package com.crm.rest.restservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handlerException (CustomerNotFoundException exc){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handlerException (Exception exc){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }

}

package com.smartphone.phoneStore.config;


import com.smartphone.phoneStore.ecxeption.ErrorObject;
import com.smartphone.phoneStore.ecxeption.ReferenceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalConfig {

    @ExceptionHandler(ReferenceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleReferenceNotFoundException(ReferenceNotFoundException ex){

        ErrorObject errObj = ErrorObject.builder()
                .title("Smartphone not found ")
                .description(ex.getMessage())
                .build();

        return new ResponseEntity<ErrorObject>(errObj, HttpStatus.BAD_REQUEST);
    }

}
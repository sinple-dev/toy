package com.example.toy.common.result;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {



//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler (CustomException.class)
    public ErrorResponse handleAlreadyExistEmail(CustomException ex) {

        ErrorResponse er = new ErrorResponse();
        er.setCode(ex.getErrorCode().getCode());
        er.setStatus(ex.getErrorCode().getStatus());
        er.setMessage(ex.getMessage());

        return new ErrorResponse(er);
    }

}
